package com.example.Challenge_Op_Fuego.repositories;

import com.example.Challenge_Op_Fuego.models.InformacionSateliteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InformacionSateliteRepository extends CrudRepository<InformacionSateliteModel, Integer> {
    public abstract ArrayList<InformacionSateliteModel> findByNombre(String nombre);
}
