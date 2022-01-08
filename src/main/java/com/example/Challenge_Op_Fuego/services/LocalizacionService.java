package com.example.Challenge_Op_Fuego.services;

import com.example.Challenge_Op_Fuego.exceptions.LocalizacionException;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

@Service
public class LocalizacionService {
    public double[] getLocation(double[][] positions, double [] distances) throws LocalizacionException{

        if( positions.length != distances.length )
            throw new LocalizacionException("Numero de Posiciones Diferente al Numero de Distancias");

        if( positions.length < 2 )
            throw new LocalizacionException("Numero de Posiciones Insuficientes");

        if( positions.length < 2 )
            throw new LocalizacionException("Numero de Posiciones Insuficientes");

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return  nSolver.solve().getPoint().toArray();
    }
}
