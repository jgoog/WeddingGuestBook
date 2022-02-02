package com.example.weddingguestbook.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @GetMapping(path = "/test-world/")
    public String getHelloWorld(){
        return "Test World";
    }
    





}
