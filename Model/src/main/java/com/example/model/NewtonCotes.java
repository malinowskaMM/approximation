package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class NewtonCotes {

    double splitInterval(double begin, double end, int intervalsNumber) {
        return (end-begin)/intervalsNumber;
    }
    double calculateNodes(double begin, double end, int m, int n) {
        return 1.0/2*((end-begin)*Math.cos(((2.0*m+1)/(2*n+2))*Math.PI)+(end+begin));
    }




    double czebyszewFunctionT(double x, int level, double begin, double end) {
        if(level==0)
        {
            return 1;
        }
        else if(level==1)
        {
            return x;
        }
        double result = 2*x*czebyszewFunctionT(x, level-1, begin, end)-czebyszewFunctionT(x, level-2, begin, end);
        return result;
    }


    public double chooseFunctionPackage(String function, double x, int level, double begin, double end) {
        double result = Functions.chooseFunction(function,x)*czebyszewFunctionT(x, level, begin, end)*(1/Math.sqrt(1-Math.pow( x,2)));
        return result;
    }

    public double calculateA(int level, double begin, double end, int N, String function) {
        double result = 0;
        double sumMiddlePointsValues=0;
        double pointsDistance;
        double splitPoint;

        pointsDistance = splitInterval(begin, end, N);

        for(int i = 1; i <= N; i++) {
            splitPoint = begin + i * pointsDistance;
            sumMiddlePointsValues += chooseFunctionPackage(function, splitPoint - pointsDistance/2, level, begin, end);

            if(i < N) {
                result += chooseFunctionPackage(function, splitPoint, level, begin, end);
            }

        }
        result = pointsDistance / 6 * (chooseFunctionPackage(function, begin, level, begin, end)
                + chooseFunctionPackage(function, end, level, begin, end)
                +2*result
                +4*sumMiddlePointsValues);

        return (2/Math.PI)*result;
    }

    public double calculateFunction(int level, double x, int N, String function, double begin, double end) {
        double result = 0;
        List<Double> coefficients = new ArrayList<>();
        for(int i = 0; i < level; i++) {
            double r;
            if(i == 0) {
                r = (calculateA(i, begin, end, N, function) / 2);
                //System.out.println(result);
            } else {
                r = calculateA(i, begin, end, N, function) * czebyszewFunctionT(x, i, begin, end);
                //System.out.println(result);
                }
            result += r;
            coefficients.add(r);
        }
        //System.out.println(coefficients);
        return result;
    }

}