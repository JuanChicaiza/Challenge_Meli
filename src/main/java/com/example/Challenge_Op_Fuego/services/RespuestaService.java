package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.models.RespuestasDBModel;
import com.example.Challenge_Op_Fuego.repositories.RespuestasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    RespuestasRepository respuestasRepository;

    public void registrarRespuesta(RespuestasDBModel respuestasDBModel){
        respuestasRepository.save(respuestasDBModel);
    }
}
