package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.*;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.element.TransactionElement;
import com.enigma.api.inventory.models.request.TransactionRequest;
import com.enigma.api.inventory.models.response.TransactionResponse;
import com.enigma.api.inventory.models.search.TransactionSearch;
import com.enigma.api.inventory.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionTypeService transactionTypeService;

    @Autowired
    private TransactionStatusService transactionStatusService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<TransactionResponse> add(@Valid @RequestBody TransactionRequest request) {

        Transaction entity = modelMapper.map(request, Transaction.class);

        Customer customer = customerService.findById(request.getCustomerId());
        TransactionType transactionType = transactionTypeService.findById(request.getTransactionTypeId());
        TransactionStatus transactionStatus = new TransactionStatus();

        if (customer.getBalance() > request.getAmount()) {
            transactionStatus.setId(request.getTransactionStatusId());
            transactionStatus.setStatus("Success");
            transactionStatus = transactionStatusService.save(transactionStatus);

            TransactionStatus findIdTrxStatus = transactionStatusService.findById(request.getTransactionStatusId());
            entity.setCustomer(customer);
            entity.setTransactionType(transactionType);
            entity.setTransactionStatus(findIdTrxStatus);
            customer.setBalance(customer.getBalance() - request.getAmount());
            entity = service.save(entity);
        } else {
            transactionStatus.setId(request.getTransactionStatusId());
            transactionStatus.setStatus("Failed");
            transactionStatus = transactionStatusService.save(transactionStatus);

            TransactionStatus findIdTrxStatus = transactionStatusService.findById(request.getTransactionStatusId());
            entity.setCustomer(customer);
            entity.setTransactionType(transactionType);
            entity.setTransactionStatus(findIdTrxStatus);
            entity = service.save(entity);
        }

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionResponse> edit(@PathVariable Integer id, @RequestBody TransactionRequest request) {

        Transaction entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

//        Customer customer = customerService.findById(request.getCustomerId());
//        TransactionType transactionType = transactionTypeService.findById(request.getTransactionTypeId());
//        TransactionStatus transactionStatus = transactionStatusService.findById(request.getTransactionStatusId());
//        entity.setCustomer(customer);
//        entity.setTransactionType(transactionType);
//        entity.setTransactionStatus(transactionStatus);

        request = getRequest(request, entity);

        modelMapper.map(request, entity);
        entity = service.save(entity);

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        Transaction entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        Transaction entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<TransactionElement>> findAll(
            @Valid TransactionSearch model
    ) {
        Transaction search = modelMapper.map(model, Transaction.class);

        Page<Transaction> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Transaction> entities = entityPage.toList();

        List<TransactionElement> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionElement.class))
                .collect(Collectors.toList());

        PageList<TransactionElement> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    public TransactionRequest getRequest(TransactionRequest request, Transaction transaction) {
        if (request.getAmount() == null) request.setAmount(transaction.getAmount());
        if (request.getCustomerId() == null) request.setCustomerId(transaction.getCustomer().getId());
        if (request.getTransactionTypeId() == null)
            request.setTransactionTypeId(transaction.getTransactionType().getId());
        if (request.getTransactionStatusId() == null)
            request.setTransactionStatusId(transaction.getTransactionStatus().getId());
        transaction.setCustomer(customerService.findById(request.getCustomerId()));
        transaction.setTransactionType(transactionTypeService.findById(request.getTransactionTypeId()));
        transaction.setTransactionStatus(transactionStatusService.findById(request.getTransactionStatusId()));
        return request;
    }

}
