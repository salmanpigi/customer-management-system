package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.*;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.response.TransactionStatusModel;
import com.enigma.api.inventory.models.search.TransactionStatusSearch;
import com.enigma.api.inventory.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/transaction-status")
@RestController
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<TransactionStatusModel> add(@Valid @RequestBody TransactionStatusModel model) {

        TransactionStatus entity = modelMapper.map(model, TransactionStatus.class);

        entity = service.save(entity);

        TransactionStatusModel data = modelMapper.map(entity, TransactionStatusModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionStatusModel> edit(@PathVariable Integer id,
                                                        @RequestBody TransactionStatusModel model) {

        TransactionStatus entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        modelMapper.map(model, entity);
        entity = service.save(entity);

        TransactionStatusModel data = modelMapper.map(entity, TransactionStatusModel.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        TransactionStatus entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionStatusModel data = modelMapper.map(entity, TransactionStatusModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        TransactionStatus entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionStatusModel data = modelMapper.map(entity, TransactionStatusModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<TransactionStatusModel>> findAll(
            @Valid TransactionStatusSearch model
    ) {
        TransactionStatus search = modelMapper.map(model, TransactionStatus.class);

        Page<TransactionStatus> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<TransactionStatus> entities = entityPage.toList();

        List<TransactionStatusModel> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionStatusModel.class))
                .collect(Collectors.toList());

        PageList<TransactionStatusModel> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

}
