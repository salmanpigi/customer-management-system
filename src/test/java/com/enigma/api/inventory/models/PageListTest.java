//package com.enigma.api.inventory.models;
//
//import com.enigma.api.inventory.models.pagginations.PageList;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class PageListTest {
//
//    @InjectMocks
//    private PageList<Item> pageList;
//
//    @Mock
//    private List<Item> itemList;
//
//    @Test
//    void getterSetterTest() {
//        pageList = new PageList<>();
//        pageList.setList(itemList);
//        pageList.setPage(1);
//        pageList.setSize(10);
//        pageList.setTotal(10L);
//
//        assertEquals(itemList, pageList.getList());
//        assertEquals(1, pageList.getPage());
//        assertEquals(10, pageList.getSize());
//        assertEquals(10L, pageList.getTotal());
//    }
//}
