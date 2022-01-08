package com.example.Challenge_Op_Fuego.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nave")
public class NaveAlmacenadaModel {
    @Id
    private String name;
    private double distance;
    @ElementCollection()
    @CollectionTable(name = "mensajes_nave",joinColumns = @JoinColumn(name = "name"))
    @OrderColumn
    private List<String> message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
