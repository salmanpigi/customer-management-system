package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.search.AccountTypeSearch;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.response.AccountTypeModel;
import com.enigma.api.inventory.services.AccountTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/account-type")
@RestController
public class AccountTypeController {
    @Autowired
    private AccountTypeService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<AccountTypeModel> add(@Valid @RequestBody AccountTypeModel model) {

        AccountType entity = modelMapper.map(model, AccountType.class);
        entity = service.save(entity);

        AccountTypeModel data = modelMapper.map(entity, AccountTypeModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<AccountTypeModel> edit(@PathVariable Integer id, @RequestBody AccountTypeModel model) {

        AccountType entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);

        AccountTypeModel data = modelMapper.map(entity, AccountTypeModel.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        AccountType entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        AccountTypeModel data = modelMapper.map(entity, AccountTypeModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        AccountType entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        AccountTypeModel data = modelMapper.map(entity, AccountTypeModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<AccountTypeModel>> findAll(
            @Valid AccountTypeSearch model
    ) {
        AccountType search = modelMapper.map(model, AccountType.class);

        Page<AccountType> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<AccountType> entities = entityPage.toList();

        List<AccountTypeModel> models = entities.stream()
                .map(e -> modelMapper.map(e, AccountTypeModel.class))
                .collect(Collectors.toList());

        PageList<AccountTypeModel> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }
}
