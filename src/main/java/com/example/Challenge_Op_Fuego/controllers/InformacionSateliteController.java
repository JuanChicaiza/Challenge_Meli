package com.example.Challenge_Op_Fuego.controllers;

import com.example.Challenge_Op_Fuego.models.InformacionSateliteModel;
import com.example.Challenge_Op_Fuego.services.InformacionSateliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/satelites")
public class InformacionSateliteController {
    @Autowired
    InformacionSateliteService informacionSateliteService;

    @GetMapping()
    public ArrayList<InformacionSateliteModel> consultarSatelites(){
        return informacionSateliteService.consultarSatelites();
    }

    @PostMapping()
    public InformacionSateliteModel registrarSatelite(@RequestBody InformacionSateliteModel satelite){
        return informacionSateliteService.registarSatelite(satelite);
    }

    @GetMapping(path = "/{id}")
    public Optional<InformacionSateliteModel> consultarSatelitePorId(@PathVariable("id") Integer id){
        return informacionSateliteService.consultarSatelitePorId(id);
    }
}

