package com.enigma.api.inventory.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(DefaultErrorController.class)
public class DefaultErrorControllerTest {

    @Autowired
    DefaultErrorController errorController;

    @Autowired
    MockMvc mvc;

    @Test
    void errorShouldHandle() throws Exception {
        RequestBuilder request = get("/error")
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.NOT_FOUND.value())))
                .andExpect(jsonPath("$.message", is("Path Not Found.")));

    }

    @Test
    void getErrorPath() {
        String errorPath = errorController.getErrorPath();
        assertEquals(null, errorPath);
    }
}
