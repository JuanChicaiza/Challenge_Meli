package com.example.Challenge_Op_Fuego.models;

public class PosicionModel {
    private double x;

    private  double y;

    public PosicionModel(double[] puntos){
        this.x = puntos[0];
        this.y = puntos[1];
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
