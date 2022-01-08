package com.example.Challenge_Op_Fuego.repositories;

import com.example.Challenge_Op_Fuego.models.PeticionesBDModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionesRepository extends CrudRepository<PeticionesBDModel,Integer> {

}
