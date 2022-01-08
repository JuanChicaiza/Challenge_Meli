package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.models.NumeroPeticionModel;
import com.example.Challenge_Op_Fuego.models.PeticionesBDModel;
import com.example.Challenge_Op_Fuego.repositories.NumeroRepository;
import com.example.Challenge_Op_Fuego.repositories.PeticionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeticionesSatelitesService {
    @Autowired
    PeticionesRepository peticionesRepository;
    @Autowired
    NumeroRepository numeroRepository;

    public void registrarPeticion(PeticionesBDModel peticionesBDModel){
        peticionesRepository.save(peticionesBDModel);
    }

    public void actualizarNumero(NumeroPeticionModel numeroPeticionModel){
        numeroRepository.save(numeroPeticionModel);
    }
    public Optional<NumeroPeticionModel> consultarNumero(Integer id){
        return numeroRepository.findById(id);
    }

}
