package com.company;

public class Sofa implements IntFurnitureTwoParam {
    String sofa = new String();
    double minSize = 0;
    double maxSize = 0;

    public Sofa(double minSize,double maxSize){
        this.sofa = "Диван";
        this.minSize = minSize;
        this.maxSize = maxSize;
    }


    @Override
    public String getFurniture() {
        return sofa;
    }

    @Override
    public double getMinSize() {
        return minSize;
    }

    @Override
    public double getMaxSize() {
        return maxSize;
    }
}
