package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.Staff;
import com.enigma.api.inventory.entities.User;
import com.enigma.api.inventory.exceptions.EntityNotFoundException;
import com.enigma.api.inventory.messages.ResponseMessage;
import com.enigma.api.inventory.models.element.CustomerElement;
import com.enigma.api.inventory.models.element.StaffElement;
import com.enigma.api.inventory.models.pagginations.PageList;
import com.enigma.api.inventory.models.request.CustomerRequest;
import com.enigma.api.inventory.models.request.StaffRequest;
import com.enigma.api.inventory.models.response.CustomerResponse;
import com.enigma.api.inventory.models.response.StaffResponse;
import com.enigma.api.inventory.models.search.CustomerSearch;
import com.enigma.api.inventory.models.search.StaffSearch;
import com.enigma.api.inventory.services.AccountTypeService;
import com.enigma.api.inventory.services.CustomerService;
import com.enigma.api.inventory.services.StaffService;
import com.enigma.api.inventory.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/staffs")
@RestController
public class StaffController {
    @Autowired
    private StaffService service;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<StaffResponse> add(@Valid @RequestBody StaffRequest request) {

        Staff staff = modelMapper.map(request, Staff.class);

        User user = userService.findById(request.getUserId());
        staff.setUser(user);

        staff = service.save(staff);

        StaffResponse data = modelMapper.map(staff, StaffResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<StaffResponse> edit(@PathVariable Integer id, @RequestBody StaffRequest request) {

        Staff staff = service.findById(id);
        if (staff == null) {
            throw new EntityNotFoundException();
        }

        request = getRequest(request, staff);

        modelMapper.map(request, staff);
        staff = service.save(staff);

        StaffResponse data = modelMapper.map(staff, StaffResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage removeById(@PathVariable Integer id) {
        Staff entity = service.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        StaffResponse data = modelMapper.map(entity, StaffResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage findById(@PathVariable Integer id) {
        Staff entity = service.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        StaffResponse data = modelMapper.map(entity, StaffResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<StaffElement>> findAll(
            @Valid StaffSearch model
    ) {
        Staff search = modelMapper.map(model, Staff.class);

        Page<Staff> entityPage = service.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Staff> entities = entityPage.toList();

        List<StaffElement> models = entities.stream()
                .map(e -> modelMapper.map(e, StaffElement.class))
                .collect(Collectors.toList());

        PageList<StaffElement> data = new PageList(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    public StaffRequest getRequest(StaffRequest request, Staff staff) {
        if (request.getIdCard() == null) request.setIdCard(staff.getIdCard());
        if (request.getName() == null) request.setName(staff.getName());
        if (request.getGender() == null) request.setGender(staff.getGender());
        if (request.getAddress() == null) request.setAddress(staff.getAddress());
        if (request.getPhoneNumber() == null) request.setPhoneNumber(staff.getPhoneNumber());
        if (request.getRole() == null) request.setRole(staff.getRole());
        if (request.getDivision() == null) request.setDivision(staff.getDivision());
        if (request.getUserId() == null) request.setUserId(staff.getUser().getId());
        staff.setUser(userService.findById(request.getUserId()));
        return request;
    }

}
