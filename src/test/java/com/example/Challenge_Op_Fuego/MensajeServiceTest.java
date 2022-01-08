package com.example.Challenge_Op_Fuego;

import com.example.Challenge_Op_Fuego.exceptions.MensajeException;
import com.example.Challenge_Op_Fuego.services.MensajeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MensajeServiceTest {
    @Autowired
    MensajeService mensajeService;

    @Test
    public void getMessageWith3Satellites() throws MensajeException {
        List<List<String>> messages = new ArrayList<List<String>>();
        String [] m1 = {"este", "", "", "mensaje", ""};
        String [] m2 = {"", "es", "", "", "secreto"};
        String [] m3 = {"este", "", "un", "", ""};
        messages.add(Arrays.stream(m1).collect(Collectors.toList()));
        messages.add(Arrays.stream(m2).collect(Collectors.toList()));
        messages.add(Arrays.stream(m3).collect(Collectors.toList()));
        String message = mensajeService.getMessage(messages);
        String expectedMsg = "este es un mensaje secreto";
        assertEquals(message,expectedMsg);
    }

    @Test
    public void getMessageWith3SatellitesError(){
        List<List<String>> messages = new ArrayList<List<String>>();
        String [] m1 = {"este", "", "", "mensaje", ""};
        String [] m2 = {"", "es", "", "", "secreto"};
        String [] m3 = {"este", "", "un", "", "",""};
        messages.add(Arrays.stream(m1).collect(Collectors.toList()));
        messages.add(Arrays.stream(m2).collect(Collectors.toList()));
        messages.add(Arrays.stream(m3).collect(Collectors.toList()));
        try {
            String message = mensajeService.getMessage(messages);
        }catch (MensajeException e){
            assertEquals("No se puede conocer el mensaje",e.getMessage());
        }
    }

    @Test
    public void getMessageWith4Satellites() throws MensajeException {
        List<List<String>> messages = new ArrayList<List<String>>();
        String [] m1 = {"este", "", "", "mensaje", ""};
        String [] m2 = {"", "es", "", "", "secreto"};
        String [] m3 = {"este", "", "un", "", ""};
        String [] m4 = {"", "", "un", "", "secreto"};
        messages.add(Arrays.stream(m1).collect(Collectors.toList()));
        messages.add(Arrays.stream(m2).collect(Collectors.toList()));
        messages.add(Arrays.stream(m3).collect(Collectors.toList()));
        messages.add(Arrays.stream(m4).collect(Collectors.toList()));
        String message = mensajeService.getMessage(messages);
        String expectedMsg = "este es un mensaje secreto";
        assertEquals(message,expectedMsg);
    }
}
