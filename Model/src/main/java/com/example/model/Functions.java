package com.example.model;

public class Functions {
    static HornerScheme hornerScheme = new HornerScheme();

    double functionI(double x){
        double[] factors = {1,1,-2,0,0,-3};
        return hornerScheme.horner(factors,factors.length, x );
    }

    double functionII(double x){
        return Math.cos(x) + (x-1) * Math.sin(x);
    }

    double functionIII(double x){
        return Math.abs(Math.pow(Math.cos(x),2)+1);
    }

}
