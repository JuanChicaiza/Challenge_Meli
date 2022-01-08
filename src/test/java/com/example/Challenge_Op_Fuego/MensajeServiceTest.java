package com.example.Challenge_Op_Fuego;

import com.example.Challenge_Op_Fuego.exceptions.MensajeException;
import com.example.Challenge_Op_Fuego.services.MensajeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    public static final String [] MESSAGE1 = {"este", "", "", "mensaje", ""};
    public static final String [] MESSAGE2 = {"", "es", "", "", "secreto"};
    public static final String [] MESSAGE3 = {"este", "", "un", "", "",""};
    public static final String [] MESSAGE4 = {"", "", "un", "", "secreto"};

    List<List<String>> messages = new ArrayList<List<String>>();

    @BeforeEach
    public void setUp() {
        messages.add(Arrays.stream(MESSAGE1).collect(Collectors.toList()));
        messages.add(Arrays.stream(MESSAGE2).collect(Collectors.toList()));
        messages.add(Arrays.stream(MESSAGE3).collect(Collectors.toList()));
    }

    @AfterEach
    public void clear() {
        messages.clear();
    }

    @Test
    public void getMessageWith3Satellites() throws MensajeException {
        String message = mensajeService.getMessage(messages);
        String expectedMsg = "este es un mensaje secreto";
        assertEquals(message,expectedMsg);
    }

    @Test
    public void getMessageWith3SatellitesError(){
        try {
            String message = mensajeService.getMessage(messages);
        }catch (MensajeException e){
            assertEquals("No se puede conocer el mensaje",e.getMessage());
        }
    }

    @Test
    public void getMessageWith4Satellites() throws MensajeException {
        messages.add(Arrays.stream(MESSAGE4).collect(Collectors.toList()));
        String message = mensajeService.getMessage(messages);
        String expectedMsg = "este es un mensaje secreto";
        assertEquals(message,expectedMsg);
    }
}