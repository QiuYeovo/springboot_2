package com.lzq01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getID(){
        System.out.println("spring:6666666");
        return "springboot:777777";
    }
}
