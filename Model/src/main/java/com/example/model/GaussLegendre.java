package com.example.model;

public class GaussLegendre {

    //z wykładu
    public double[] getNodesValues(int nodesNumber) {
        double[] nodesValues = new double[nodesNumber];
        switch (nodesNumber) {
            case 2 -> {
                nodesValues[0] = -Math.sqrt(3) / 3;
                nodesValues[1] = -nodesValues[0];
            }
            case 3 -> {
                nodesValues[0] = -Math.sqrt(15) / 5;
                nodesValues[1] = 0;
                nodesValues[2] = Math.sqrt(15) / 5;
            }
            case 4 -> {
                nodesValues[0] = -Math.sqrt(525 + 70 * Math.sqrt(30)) / 35;
                nodesValues[1] = -Math.sqrt(525 - 70 * Math.sqrt(30)) / 35;
                nodesValues[2] = -nodesValues[1];
                nodesValues[3] = -nodesValues[0];
            }
            case 5 -> {
                nodesValues[0] = -Math.sqrt(245 + 14 * Math.sqrt(70)) / 21;
                nodesValues[1] = -Math.sqrt(245 - 14 * Math.sqrt(70)) / 21;
                nodesValues[2] = 0;
                nodesValues[3] = -nodesValues[1];
                nodesValues[4] = -nodesValues[0];
            }
        }
        return nodesValues;
    }


    //z wykładu
    public double[] getQuadratureFactors(int nodesNumber) {
        double[] factorsValues = new double[nodesNumber];
        switch (nodesNumber) {
            case 2 -> {
                factorsValues[0] = 1;
                factorsValues[1] = 1;
            }
            case 3 -> {
                factorsValues[0] = 5.0 / 9;
                factorsValues[1] = 8.0 / 9;
                factorsValues[2] = factorsValues[0];
            }
            case 4 -> {
                factorsValues[0] = (18 - Math.sqrt(30)) / 26;
                factorsValues[1] = (18 + Math.sqrt(30)) / 26;
                factorsValues[2] = factorsValues[1];
                factorsValues[3] = factorsValues[0];
            }
            case 5 -> {
                factorsValues[0] = (322 - 13 * Math.sqrt(70)) / 900;
                factorsValues[1] = (322 + 13 * Math.sqrt(70)) / 900;
                factorsValues[2] = 128.0 / 225;
                factorsValues[3] = factorsValues[1];
                factorsValues[4] = factorsValues[0];
            }
        }
        return factorsValues;
    }

}
