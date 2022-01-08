package com.example.Challenge_Op_Fuego.models;

import java.util.ArrayList;
import java.util.List;

public class PeticionesSatelitesModel {
    List<SatelitesModel> satellites;

    public List<SatelitesModel> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatelitesModel> satelites) {
        this.satellites = satelites;
    }

    public List<List<String>> getMensajesPeticion(){
        List<List<String>> mensajes = new ArrayList<List<String>>();
        for(SatelitesModel s: satellites){
            mensajes.add(s.getMessage());
        }
        return mensajes;
    }
}
