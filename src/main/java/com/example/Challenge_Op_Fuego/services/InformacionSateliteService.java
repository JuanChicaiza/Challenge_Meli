package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.models.InformacionSateliteModel;
import com.example.Challenge_Op_Fuego.repositories.InformacionSateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InformacionSateliteService {
    @Autowired
    InformacionSateliteRepository informacionSateliteRepository;

    public ArrayList<InformacionSateliteModel> consultarSatelites(){
        return (ArrayList<InformacionSateliteModel>) informacionSateliteRepository.findAll();
    }

    public InformacionSateliteModel registarSatelite(InformacionSateliteModel satelite){
        return informacionSateliteRepository.save(satelite);
    }

    public Optional<InformacionSateliteModel> consultarSatelitePorId(Integer id){
        return informacionSateliteRepository.findById(id);
    }

    public ArrayList<InformacionSateliteModel> consultarSatelitePorNombre(String nombre){
        return informacionSateliteRepository.findByNombre(nombre);
    }


}
