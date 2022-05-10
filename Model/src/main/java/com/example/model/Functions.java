package com.example.model;

public class Functions {
    static HornerScheme hornerScheme = new HornerScheme();

    public static double chooseFunction(String function, double x) {
        return switch (function) {
            case "functionI" -> functionI(x);
            case "functionII" -> functionII(x);
            case "functionIII" -> functionIII(x);
            case "functionIV" -> functionIV(x);
            case "functionV" -> functionV(x);
            default -> 0;
        };
    }

    public static double functionI(double x){
        return 2*x+1;
    }

    public static double functionII(double x){
        return Math.abs(x);
    }

    public static double functionIII(double x){
        double[] factors = {1,1,-2,0,0,-3};
        return hornerScheme.horner(factors,factors.length, x );
    }

    public static double functionIV(double x){
        return Math.cos(x);
    }

    public static double functionV(double x){
        double[] factors = {1,0,0,1};
        return Math.abs(Math.cos(x)+1)+hornerScheme.horner(factors,factors.length,x);
    }

}
