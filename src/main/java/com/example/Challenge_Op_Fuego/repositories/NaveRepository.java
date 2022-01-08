package com.example.Challenge_Op_Fuego.repositories;

import com.example.Challenge_Op_Fuego.models.NaveAlmacenadaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaveRepository extends CrudRepository<NaveAlmacenadaModel, String> {
}
