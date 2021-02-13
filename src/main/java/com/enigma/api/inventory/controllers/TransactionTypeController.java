package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.entities.TransactionType;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.response.AccountTypeModel;
import com.enigma.api.inventory.models.response.TransactionTypeModel;
import com.enigma.api.inventory.models.search.AccountTypeSearch;
import com.enigma.api.inventory.services.TransactionTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/transaction-type")
@RestController
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<TransactionTypeModel> add(@Valid @RequestBody TransactionTypeModel model) {

        TransactionType entity = modelMapper.map(model, TransactionType.class);
        entity = service.save(entity);

        TransactionTypeModel data = modelMapper.map(entity, TransactionTypeModel.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionTypeModel> edit(@PathVariable Integer id, @RequestBody TransactionTypeModel model) {

        TransactionType entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model, entity);
        entity = service.save(entity);

        TransactionTypeModel data = modelMapper.map(entity, TransactionTypeModel.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        TransactionType entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionTypeModel data = modelMapper.map(entity, TransactionTypeModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        TransactionType entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        TransactionTypeModel data = modelMapper.map(entity, TransactionTypeModel.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<TransactionTypeModel>> findAll(
            @Valid AccountTypeSearch model
    ) {
        TransactionType search = modelMapper.map(model, TransactionType.class);

        Page<TransactionType> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<TransactionType> entities = entityPage.toList();

        List<TransactionTypeModel> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionTypeModel.class))
                .collect(Collectors.toList());

        PageList<TransactionTypeModel> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }
}
