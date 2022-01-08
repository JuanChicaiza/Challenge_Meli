package com.example.Challenge_Op_Fuego.models;

public class UbicacionModel {
    private PosicionModel position;
    private String message;
    public UbicacionModel(PosicionModel puntos, String message){
        this.setPosition(puntos);
        this.message = message;
    }
    public PosicionModel getPosition() {
        return position;
    }

    public void setPosition(PosicionModel position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
