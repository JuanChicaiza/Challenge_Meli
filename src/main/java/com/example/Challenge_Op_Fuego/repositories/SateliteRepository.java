package com.example.Challenge_Op_Fuego.repositories;

import com.example.Challenge_Op_Fuego.models.SatelitesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SateliteRepository extends CrudRepository<SatelitesModel, String> {
}
