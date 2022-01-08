package com.example.Challenge_Op_Fuego.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numero_peticiones")
public class NumeroPeticionModel {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    private Long numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
