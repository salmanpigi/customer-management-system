//package com.enigma.api.inventory.services;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Sort;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UnitServiceTest {
//
//    @InjectMocks
//    private UnitServiceImpl service;
//
//    @Mock
//    private UnitRepository repository;
//
//    @Test
//    void addEntityShouldSave() {
//        Unit input = new Unit();
//        input.setCode("xyz");
//        input.setDescription("XYZ");
//
//        Unit output = new Unit();
//        output.setId(1);
//        output.setCode("xyz");
//        output.setDescription("XYZ");
//
//        when(repository.save(any())).thenReturn(output);
//        Unit result = service.save(input);
//        assertEquals(output, result);
//    }
//
//    @Test
//    void findByIdShouldReturnEntity() {
//        Unit output = new Unit();
//        when(repository.findById(1)).thenReturn(Optional.of(output));
//        Unit result = service.findById(1);
//        Assertions.assertEquals(output, result);
//    }
//
//    @Test
//    void findAllShouldReturnEntities() {
//        List<Unit> output = new ArrayList<>();
//        when(repository.findAll(Sort.by("id"))).thenReturn(output);
//        List<Unit> result = service.findAll();
//        Assertions.assertEquals(output, result);
//    }
//
//    @Test
//    void removeByIdShouldRemoveEntity() {
//        Unit result = service.removeById(1);
//        Assertions.assertEquals(result, null);
//    }
//
//}
