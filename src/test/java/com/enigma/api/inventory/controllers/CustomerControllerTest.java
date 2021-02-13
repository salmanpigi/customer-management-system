package com.enigma.api.inventory.controllers;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.models.response.CustomerResponse;
import com.enigma.api.inventory.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService service;

    @MockBean
    private ModelMapper modelMapper;

    private Customer customer;
    private CustomerResponse customerResponse;

    @BeforeEach
    void init() {
        customer = new Customer();
        customer.setId(1);
        customer.setName("abc");
        customer.setAddress("def");

        customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setAddress(customerResponse.getAddress());
        when(service.save(any())).thenReturn(customer);

        when(modelMapper.map(any(Customer.class), any(Class.class))).thenReturn(customerResponse);
    }

    @Test
    void addShouldSuccess() throws Exception {
        RequestBuilder request = post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"abc\", \"address\": \"def\"} ");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$.code", is(HttpStatus.OK.value()))))
                .andExpect(jsonPath("$.data.name", is(customer.getName())));
    }

    @Test
    void editShouldSuccess() throws Exception {
        when(service.findById(1)).thenReturn(customer);
        Customer customer = new Customer();
        customer.setName("def");
        customer.setAddress("abc");

        when(service.findById(anyInt())).thenReturn(customer);
        when(service.save(any())).thenReturn(customer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setAddress(customerResponse.getAddress());

        when(modelMapper.map(any(Customer.class), any(Class.class))).thenReturn(customerResponse);

        RequestBuilder request = put("/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"def\", \"address\": \"abc\"} ");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$.code", is(HttpStatus.OK.value()))))
                .andExpect(jsonPath("$.data.name", is(customer.getName())));

    }

    @Test
    void getIdShouldReturnEntity() throws Exception {
        when(service.findById(1)).thenReturn(customer);

        RequestBuilder request = get("/customers/1")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$.code", is(HttpStatus.OK.value()))))
                .andExpect(jsonPath("$.data.name", is(customer.getName())));
    }

    @Test
    void removeByIdShouldSuccess() throws Exception {
        when(service.removeById(1)).thenReturn(customer);

        RequestBuilder request = delete("/customers/1")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$.code", is(HttpStatus.OK.value()))))
                .andExpect(jsonPath("$.data.name", is(customer.getName())));
    }

    @Test
    void findAllShouldReturnEmptyList() throws Exception {
        Page page = Page.empty();
        when(service.findAll(any(), anyInt(), anyInt(), any())).thenReturn(page);

        mvc.perform(get("/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.list", empty()));
    }

    @Test
    void findByIdShouldCallException() throws Exception {
        when(service.findById(2)).thenReturn(customer);
        RequestBuilder request = get("/customers/1")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$.code", is(HttpStatus.NOT_FOUND.value()))))
                .andExpect(jsonPath("$.message", is("Entity Not Found.")));
    }
}
