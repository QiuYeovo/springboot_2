package com.lyb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;
    @Test
    void getId(){
        System.out.println(bookService.getById(2));
    }
}