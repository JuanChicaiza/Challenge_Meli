package com.example.Challenge_Op_Fuego.controllers;

import com.example.Challenge_Op_Fuego.exceptions.LocalizacionException;
import com.example.Challenge_Op_Fuego.exceptions.MensajeException;
import com.example.Challenge_Op_Fuego.models.*;
import com.example.Challenge_Op_Fuego.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/topsecret")
public class PeticionesController {
    @Autowired
    InformacionSateliteService informacionSateliteService;

    ArrayList<InformacionSateliteModel> infoSatellites;
    InformacionSateliteModel infoSatellite;
    PeticionesSatelitesModel satellites;
    SatelitesModel satellite;
    PeticionesBDModel peticionesBDModel ;
    Optional<NumeroPeticionModel> numeroPeticionModel;
    NumeroPeticionModel numeroPeticion;
    RespuestasDBModel respuestasDBModel;

    @Autowired
    LocalizacionService localizacionService;

    @Autowired
    MensajeService mensajeService;

    @Autowired
    PeticionesSatelitesService peticionesSatelitesService;

    @Autowired
    RespuestaService respuestaService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity topSecret(RequestEntity<PeticionesSatelitesModel> requestEntity)  {

        respuestasDBModel = new RespuestasDBModel();
        numeroPeticionModel = peticionesSatelitesService.consultarNumero(1);
        numeroPeticion = numeroPeticionModel.get();
        respuestasDBModel.setId_peticion(numeroPeticion.getNumero());

        try{
            satellites = requestEntity.getBody();
            int totalSatellites = informacionSateliteService.consultarSatelites().size();
            double [][] positions = new double[totalSatellites][2];
            double [] distances = new double[satellites.getSatellites().size()];


            for(int i = 0; i< satellites.getSatellites().size(); i++){
                peticionesBDModel = new PeticionesBDModel();
                satellite = satellites.getSatellites().get(i);
                infoSatellites = informacionSateliteService.consultarSatelitePorNombre(satellite.getName());
                infoSatellite = infoSatellites.get(0);
                positions[i][0] = infoSatellite.getPosX();
                positions[i][1] = infoSatellite.getPosY();
                distances[i] = satellite.getDistance();

                peticionesBDModel.setSatelite(infoSatellite.getId());
                peticionesBDModel.setDistancia(distances[i]);
                String mensajes = String.join(", ", satellite.getMessage());
                peticionesBDModel.setMensaje(mensajes);
                peticionesBDModel.setNumero_peticion(numeroPeticion.getNumero());
                peticionesBDModel.setSplit("NO");
                peticionesSatelitesService.registrarPeticion(peticionesBDModel);
            }

            double [] position = localizacionService.getLocation(positions,distances);
            PosicionModel posicionModel = new PosicionModel(position);
            if(satellites.getMensajesPeticion().size() <2)
                throw new MensajeException("Numero de mensajes insuficientes");
            String message = mensajeService.getMessage(satellites.getMensajesPeticion());
            respuestasDBModel.setPosX(position[0]);
            respuestasDBModel.setPosY(position[1]);
            respuestasDBModel.setMensaje(message);

            respuestaService.registrarRespuesta(respuestasDBModel);
            numeroPeticion.setNumero(numeroPeticion.getNumero()+1);
            peticionesSatelitesService.actualizarNumero(numeroPeticion);

            return ResponseEntity.status(HttpStatus.OK).body(new UbicacionModel(posicionModel,message));
        }
        catch (MensajeException e){
            respuestasDBModel.setPosX(null);
            respuestasDBModel.setPosY(null);
            respuestasDBModel.setMensaje("ERROR " + e.getMessage());
            respuestaService.registrarRespuesta(respuestasDBModel);
            numeroPeticion.setNumero(numeroPeticion.getNumero()+1);
            peticionesSatelitesService.actualizarNumero(numeroPeticion);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
        catch (LocalizacionException e){
            respuestasDBModel.setPosX(null);
            respuestasDBModel.setPosY(null);
            respuestasDBModel.setMensaje("ERROR " + e.getMessage());
            respuestaService.registrarRespuesta(respuestasDBModel);
            numeroPeticion.setNumero(numeroPeticion.getNumero()+1);
            peticionesSatelitesService.actualizarNumero(numeroPeticion);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
    }
}
