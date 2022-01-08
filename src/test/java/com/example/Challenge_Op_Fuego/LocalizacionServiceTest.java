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
    public void getLocation() throws Exception{
        double[][] posiciones = new double[][]{{-500,-200},{100,-100},{500,100}};
        double[] distancias = new double[]{100,115.5,142.7};
        double[] posicionEsperada = new double[]{-58.315252587138595,-69.55141837312165};
        double[] posicioncalculada = localizacionService.getLocation(posiciones,distancias);
        for(int i=0;i<posicioncalculada.length;i++){
            assertEquals(posicionEsperada[i],posicioncalculada[i]);
        }
    }

    @Test
    public void getLocationWith3PositionsSmall(){
        double[][] positions = new double[][]{{1.0}, {2.0}, {3.0}};
        double[] distances = new double[]{1.1, 0.1, 0.9};
        double[] expectedPosition = new double[]{2.1};
        double[] calculatedPosition = localizacionService.getLocation(positions, distances);
        for (int i = 0; i < calculatedPosition.length; i++) {
            assertEquals(expectedPosition[i], calculatedPosition[i]);
        }
    }

    @Test
    public void getLocationWith4Positions(){
        double[][] positions = new double[][]{{5.0, -6.0}, {13.0, -15.0}, {21.0, -3.0}, {12.42, -21.2}};
        double[] distances = new double[]{8.06, 13.97, 23.32, 15.31};
        double[] expectedPosition = new double[]{-0.6, -11.8};
        double acceptedDelta = 1.0;
        double[] calculatedPosition = localizacionService.getLocation(positions, distances);
        for (int i = 0; i < calculatedPosition.length; i++) {
            assertEquals(expectedPosition[i], calculatedPosition[i], acceptedDelta);
        }
    }
}
