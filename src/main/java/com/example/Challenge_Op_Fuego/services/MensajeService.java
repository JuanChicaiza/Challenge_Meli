package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.exceptions.MensajeException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
public class MensajeService {
    public String getMessage(List<List<String>> listaMensajes) throws MensajeException {

        List<String> palabras = obtenerPalabras(listaMensajes);
        if(!validarTamanoMensaje(listaMensajes, palabras.size()))
            throw new MensajeException("Tamaño del mensaje incorrecto");

        String mensaje = mensajeCompleto(listaMensajes);
        if(!validarMensajePalabras(palabras,mensaje))
            throw new MensajeException("No se puede conocer el mensaje");

        return mensaje;
    }
    private List<String> obtenerPalabras(List<List<String>> listaMensajes){

        List<String> listaPalabras = new ArrayList<String>();
        for( List<String> msj : listaMensajes){
            listaPalabras = Stream.concat(listaPalabras.stream(), msj.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        listaPalabras.remove("");
        return listaPalabras;
    }

    private String mensajeCompleto(List<List<String>> listaMensajes){

        String auxiliar = "";
        for(List<String> m : listaMensajes){

            if(m.size()>0 && !m.get(0).equals("")){
                auxiliar = (m.size() == 1) ? m.get(0) : m.get(0) + " ";
                listaMensajes.stream().forEach( s -> s.remove(0));
                return  auxiliar + mensajeCompleto(listaMensajes);
            }
        }
        return "";
    }
    private boolean validarTamanoMensaje(List<List<String>> listaMensajes, int tamano){
        for(List<String> m : listaMensajes){
            if(m.size() < tamano){
                return false;
            }
        }
        return true;
    }

    private boolean validarMensajePalabras(List<String> palabras, String mensaje){
        List<String> msj = Arrays.stream(mensaje.split(" ")).collect(Collectors.toList());
        Collections.sort(palabras);
        Collections.sort(msj);
        return Arrays.equals(palabras.toArray(), msj.toArray());
    }
}
