package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.User;
import com.enigma.api.inventory.entities.summaries.CustomerSummary;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.element.CustomerElement;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.request.CustomerRequest;
import com.enigma.api.inventory.models.response.CustomerResponse;
import com.enigma.api.inventory.models.search.CustomerSearch;
import com.enigma.api.inventory.repositories.CustomerRepository;
import com.enigma.api.inventory.services.AccountTypeService;
import com.enigma.api.inventory.services.CustomerService;
import com.enigma.api.inventory.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/customers")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<CustomerResponse> add(@Valid @RequestBody CustomerRequest request) {

        Customer customer = modelMapper.map(request, Customer.class);

        User user = userService.findById(request.getUserId());
        AccountType accountType = accountTypeService.findById(request.getAccountTypeId());
        customer.setUser(user);
        customer.setAccountType(accountType);

        customer = service.save(customer);

        CustomerResponse data = modelMapper.map(customer, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<CustomerResponse> edit(@PathVariable Integer id, @RequestBody CustomerRequest request) {

        Customer customer = service.findById(id);
        if (customer == null) {
            throw new EntityNotFoundException();
        }

        request = getRequest(request, customer);

        modelMapper.map(request, customer);
        customer = service.save(customer);

        CustomerResponse data = modelMapper.map(customer, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        Customer entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        Customer entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        CustomerResponse data = modelMapper.map(entity, CustomerResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<CustomerElement>> findAll(
            @Valid CustomerSearch model
    ) {
        Customer search = modelMapper.map(model, Customer.class);

        Page<Customer> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Customer> entities = entityPage.toList();

        List<CustomerElement> models = entities.stream()
                .map(e -> modelMapper.map(e, CustomerElement.class))
                .collect(Collectors.toList());

        PageList<CustomerElement> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    @GetMapping("/summaries")
    public ResponseMessage<List<CustomerSummary>> findAllSummaries() {
        List<CustomerSummary> entityPage = service.findAllSummaries();
        return ResponseMessage.success(entityPage);
    }

    public CustomerRequest getRequest(CustomerRequest request, Customer customer) {
        if (request.getNoAccount() == null) request.setNoAccount(customer.getNoAccount());
        if (request.getIdCard() == null) request.setIdCard(customer.getIdCard());
        if (request.getGender() == null) request.setGender(customer.getGender());
        if (request.getName() == null) request.setName(customer.getName());
        if (request.getAddress() == null) request.setAddress(customer.getAddress());
        if (request.getPhoneNumber() == null) request.setPhoneNumber(customer.getPhoneNumber());
        if (request.getBalance() == null) request.setBalance(customer.getBalance());
        if (request.getUserId() == null) request.setUserId(customer.getUser().getId());
        customer.setUser(userService.findById(request.getUserId()));
        if (request.getAccountTypeId() == null) request.setAccountTypeId(customer.getAccountType().getId());
        customer.setAccountType(accountTypeService.findById(request.getAccountTypeId()));
        return request;
    }

}
