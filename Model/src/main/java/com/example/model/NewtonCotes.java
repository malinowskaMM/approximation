package com.example.model;

public class NewtonCotes {
    Functions functions = new Functions();

    double splitInterval(double begin, double end, int intervalsNumber) {
        return (end-begin)/intervalsNumber;
    }

    double chooseFunction(String function, double x) {
        return switch (function) {
            case "functionI" -> functions.functionI(x);
            case "functionII" -> functions.functionII(x);
            case "functionIII" -> functions.functionIII(x);
            default -> 0;
        };
    }

    public double calculateNewtonCotes(double begin, double end, String function, int N) {
        double result=0;
        double sumMiddlePointsValues=0;
        double pointsDistance;
        double splitPoint;

        pointsDistance = splitInterval(begin, end, N);

        for(int i = 1; i <= N; i++) {
            splitPoint = begin + i * pointsDistance;
            sumMiddlePointsValues += chooseFunction(function, splitPoint - pointsDistance/2);

            if(i < N) {
                result += chooseFunction(function, splitPoint);
            }
        }
        result = pointsDistance / 6 * (chooseFunction(function, begin)+chooseFunction(function, end)+2*sumMiddlePointsValues+4*result);
        return result;
    }
}
