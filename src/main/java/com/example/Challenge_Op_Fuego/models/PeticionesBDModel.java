package com.example.Challenge_Op_Fuego.models;
import javax.persistence.*;

@Entity
@Table(name = "peticiones")
public class PeticionesBDModel {
    @Id
    @Column(name = "id", unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_satelite")
    private int id_satelite;
    private Double distancia;
    private String mensaje;
    private Long numero_peticion;
    private String split;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSatelite() {
        return id_satelite;
    }

    public void setSatelite(int satelite) {
        this.id_satelite = satelite;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId_satelite() {
        return id_satelite;
    }

    public void setId_satelite(int id_satelite) {
        this.id_satelite = id_satelite;
    }

    public Long getNumero_peticion() {
        return numero_peticion;
    }

    public void setNumero_peticion(Long numero_peticion) {
        this.numero_peticion = numero_peticion;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }
}
