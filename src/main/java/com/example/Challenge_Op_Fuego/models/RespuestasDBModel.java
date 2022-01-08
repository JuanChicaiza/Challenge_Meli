package com.example.Challenge_Op_Fuego.models;

import javax.persistence.*;

@Entity
@Table(name = "respuestas")
public class RespuestasDBModel {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_peticion;
    private Double posX;
    private Double posY;
    private String mensaje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_peticion() {
        return id_peticion;
    }

    public void setId_peticion(Long id_peticion) {
        this.id_peticion = id_peticion;
    }

    public Double getPosX() {
        return posX;
    }

    public void setPosX(Double posX) {
        this.posX = posX;
    }

    public Double getPosY() {
        return posY;
    }

    public void setPosY(Double posY) {
        this.posY = posY;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
