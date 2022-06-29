package com.epam.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/info")
    public String getInfo(){
        return "MVC application";
    }
}
