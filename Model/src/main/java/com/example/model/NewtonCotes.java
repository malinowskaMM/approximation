package com.example.model;

public class NewtonCotes {

    double splitInterval(double begin, double end, int intervalsNumber) {
        return (end-begin)/intervalsNumber;
    }



    public double calculateNewtonCotes(double begin, double end, String function, int N, double eps) {
        double result = 0;
        double sumMiddlePointsValues=0;
        double pointsDistance;
        double splitPoint;

        pointsDistance = splitInterval(begin, end, N);

        for(int i = 1; i <= N; i++) {
            splitPoint = begin + i * pointsDistance;
            sumMiddlePointsValues += Functions.chooseFunction(function, splitPoint - pointsDistance/2);

            if(i < N) {
                result += Functions.chooseFunction(function, splitPoint);
            }

        }
        result = pointsDistance / 6 * (Functions.chooseFunction(function, begin)+ Functions.chooseFunction(function, end)+2*result+4*sumMiddlePointsValues);
        return result;
    }
}
