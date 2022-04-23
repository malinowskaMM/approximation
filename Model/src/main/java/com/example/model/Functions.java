package com.example.model;

public class Functions {
    static HornerScheme hornerScheme = new HornerScheme();

    public static double chooseFunction(String function, double x) {
        return switch (function) {
            case "functionI" -> functionI(x);
            case "functionII" -> functionII(x);
            case "functionIII" -> functionIII(x);
            default -> 0;
        };
    }

    public static double functionI(double x){
        double[] factors = {1,1,-2,0,0,-3};
        return hornerScheme.horner(factors,factors.length, x );
    }

    public static double functionII(double x){
        return Math.cos(x) + (x-1) * Math.sin(x);
    }

    public static double functionIII(double x){
        return Math.abs(Math.pow(Math.cos(x),2)+1);
    }

}
