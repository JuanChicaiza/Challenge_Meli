package com.example.Challenge_Op_Fuego;

import com.example.Challenge_Op_Fuego.exceptions.LocalizacionException;
import com.example.Challenge_Op_Fuego.services.LocalizacionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LocalizacionServiceTest {
    @Autowired
    LocalizacionService localizacionService;

    @Test
    public void getLocation() throws LocalizacionException {
        double[][] positions = new double[][]{{-500,-200},{100,-100},{500,100}};
        double[] distances = new double[]{100,115.5,142.7};
        double[] expectedPosition = new double[]{-58.315252587138595,-69.55141837312165};
        double[] calculatedPosition = localizacionService.getLocation(positions,distances);
        for(int i=0;i<calculatedPosition.length;i++){
            assertEquals(expectedPosition[i],calculatedPosition[i]);
        }
    }

    @Test
    public void getLocationWith4Positions() throws LocalizacionException {
        double[][] positions = new double[][]{{5.0, -6.0}, {13.0, -15.0}, {21.0, -3.0}, {12.42, -21.2}};
        double[] distances = new double[]{8.06, 13.97, 23.32, 15.31};
        double[] expectedPosition = new double[]{-0.6, -11.8};
        double acceptedDelta = 1.0;
        double[] calculatedPosition = localizacionService.getLocation(positions, distances);
        for (int i = 0; i < calculatedPosition.length; i++) {
            assertEquals(expectedPosition[i], calculatedPosition[i], acceptedDelta);
        }
    }

    @Test
    public void getLocationError() throws LocalizacionException{
        double[][] positions = new double[][]{{-500,-200},{100,-100},{500,100}};
        double[] distances = new double[]{100,115.5};
        try {
            double[] calculatedPosition = localizacionService.getLocation(positions,distances);
        }catch (LocalizacionException e){
            assertEquals("Numero de Posiciones Diferente al Numero de Distancias",e.getMessage());
        }
    }
}
