package com.example.Challenge_Op_Fuego.models;

import java.util.ArrayList;
import java.util.List;

public class NaveModel {
    List<NaveAlmacenadaModel> satellites;

    public List<NaveAlmacenadaModel> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<NaveAlmacenadaModel> satelites) {
        this.satellites = satelites;
    }

    public List<List<String>> getMensajesPeticion(){
        List<List<String>> mensajes = new ArrayList<List<String>>();
        for(NaveAlmacenadaModel s: satellites){
            mensajes.add(s.getMessage());
        }
        return mensajes;
    }
}
