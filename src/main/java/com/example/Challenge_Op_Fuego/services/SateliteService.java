package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.models.SatelitesModel;
import com.example.Challenge_Op_Fuego.repositories.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SateliteService {
    @Autowired
    SateliteRepository sateliteRepository;

    public ArrayList<SatelitesModel> consultarSatelites(){
        return (ArrayList<SatelitesModel>) sateliteRepository.findAll();
    }

    public SatelitesModel registrarSatelite(SatelitesModel satelitesModel){
        return sateliteRepository.save(satelitesModel);
    }

}
