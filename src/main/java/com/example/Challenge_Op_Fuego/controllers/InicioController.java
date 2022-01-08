package com.example.Challenge_Op_Fuego.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InicioController {
    @GetMapping()
    public String inicio(){
        return "Service OK";
    }
}
