package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class NewtonCotes {

    double splitInterval(double begin, double end, int intervalsNumber) {
        return (end-begin)/intervalsNumber;
    }

    double czebyszewFunctionT(double x, int level) {
        if(level==0)
        {
            return 1;
        }
        else if(level==1)
        {
            return x;
        }
        return 1.0/2 * (Math.pow(x+Math.sqrt(Math.pow(x,2)-1),level) +  Math.pow(x-Math.sqrt(Math.pow(x,2)-1),level));
    }

    double czebyszewFactorsT(double x, int level)
    {
        return (2 * x * czebyszewFunctionT(x, level-1) - czebyszewFunctionT(x, level-2));
    }

    public double chooseFunctionPackage(String function, double x, int level) {
        return Functions.chooseFunction(function,x)*czebyszewFactorsT(x, level)*(1/Math.sqrt(1-Math.pow(x,2)));
    }

    public double calculateA(int level, double begin, double end, int N, String function) {
        double result = 0;
        double sumMiddlePointsValues=0;
        double pointsDistance;
        double splitPoint;

        pointsDistance = splitInterval(begin, end, N);

        for(int i = 1; i <= N; i++) {
            splitPoint = begin + i * pointsDistance;
            sumMiddlePointsValues += chooseFunctionPackage(function, splitPoint - pointsDistance/2, level);

            if(i < N) {
                result += chooseFunctionPackage(function, splitPoint, level);
            }

        }
        result = pointsDistance / 6 * (chooseFunctionPackage(function, begin, level)+ chooseFunctionPackage(function, end, level)+2*result+4*sumMiddlePointsValues);

        return (2/Math.PI)*result;
    }

    public double calculateFunction(int level, double x, int N, String function, double begin, double end) {
        double result = 0;
        for(int i = 0; i < level; i++) {
            if(i == 0) {
                result += (calculateA(i, begin, end, N, function)/2)*czebyszewFactorsT(x, i);
                System.out.println(result);
            }
            result += calculateA(i, begin, end, N, function)*czebyszewFactorsT(x, i);
            System.out.println(result);
        }
        return result;
    }
}