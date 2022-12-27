package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    //读取yml数据中的单一数据
    @Value("${name}")
    private String cun1;

    @GetMapping
    public String getID(){
        System.out.println("spring:6666666");
        System.out.println(cun1);
        return "springboot:777777";
    }
}
