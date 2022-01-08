package com.example.Challenge_Op_Fuego.controllers;

import com.example.Challenge_Op_Fuego.exceptions.LocalizacionException;
import com.example.Challenge_Op_Fuego.exceptions.MensajeException;
import com.example.Challenge_Op_Fuego.models.*;
import com.example.Challenge_Op_Fuego.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topsecret_split")
public class NaveAlmacenadaControler {
    @Autowired
    SateliteService sateliteService;

    @Autowired
    InformacionSateliteService informacionSateliteService;

    @Autowired
    LocalizacionService localizacionService;

    @Autowired
    MensajeService mensajeService;

    @Autowired
    PeticionesSatelitesService peticionesSatelitesService;

    @Autowired
    RespuestaService respuestaService;

    ArrayList<NaveAlmacenadaModel> satellitesModel;
    NaveAlmacenadaModel satellites;
    ArrayList<InformacionSateliteModel> infoSatellites;
    InformacionSateliteModel infoSatellite;

    @GetMapping
    public ResponseEntity topsecret_split(){
        try{
            int totalSatellites = informacionSateliteService.consultarSatelites().size();
            satellitesModel = sateliteService.consultarSatelites();
            double [][] positions = new double[totalSatellites][2];
            double [] distances = new double[satellitesModel.size()];
            List<List<String>> mensajes = new ArrayList<List<String>>();

            for(int i = 0; i< satellitesModel.size(); i++){
                satellites = satellitesModel.get(i);
                infoSatellites = informacionSateliteService.consultarSatelitePorNombre(satellites.getName());
                infoSatellite = infoSatellites.get(0);
                positions[i][0] = infoSatellite.getPosX();
                positions[i][1] = infoSatellite.getPosY();
                distances[i] = satellites.getDistance();
                mensajes.add(satellites.getMessage());
            }

            double [] position = localizacionService.getLocation(positions,distances);
            PosicionModel posicionModel = new PosicionModel(position);
            if(mensajes.size() <2)
                throw new MensajeException("Numero de mensajes insuficientes");

            String message = mensajeService.getMessage(mensajes);

            return ResponseEntity.status(HttpStatus.OK).body(new UbicacionModel(posicionModel,message));
        }
        catch (MensajeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }catch (LocalizacionException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }

    }

    @PostMapping(path = "/{satellite_name}")
    public NaveAlmacenadaModel registrarSatelite(@PathVariable("satellite_name") String name, @RequestBody NaveAlmacenadaModel naveAlmacenadaModel){
        naveAlmacenadaModel.setName(name);
        return sateliteService.registrarSatelite(naveAlmacenadaModel);
    }

    @GetMapping(path = "/satelites")
    public ArrayList<NaveAlmacenadaModel> buscarSatelites(){
        return sateliteService.consultarSatelites();
    }
}
