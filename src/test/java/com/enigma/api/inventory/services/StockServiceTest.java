//package com.enigma.api.inventory.services;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class StockServiceTest {
//
//    @InjectMocks
//    private StockServiceImpl service;
//
//    @Mock
//    private StockRepository repository;
//
//    @Test
//    void findAllSummaryShouldReturnEntities() {
//        List<StockSummary> output = new ArrayList<>();
//        when(repository.findAllSummaries()).thenReturn(output);
//        List<StockSummary> result = service.findAllSummaries();
//        Assertions.assertEquals(output, result);
//    }
//}
