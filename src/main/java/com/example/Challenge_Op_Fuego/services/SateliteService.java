package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.models.NaveAlmacenadaModel;
import com.example.Challenge_Op_Fuego.repositories.NaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SateliteService {
    @Autowired
    NaveRepository naveRepository;

    public ArrayList<NaveAlmacenadaModel> consultarSatelites(){
        return (ArrayList<NaveAlmacenadaModel>) naveRepository.findAll();
    }

    public NaveAlmacenadaModel registrarSatelite(NaveAlmacenadaModel naveAlmacenadaModel){
        return naveRepository.save(naveAlmacenadaModel);
    }

}
