package com.company;

public class Armchair implements IntFurnitureTwoParam {
    String armchair = new String();
    double minSize = 0;
    double maxSize = 0;

    public Armchair( double minSize,double maxSize){
        this.armchair = "Кресло";
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public String getFurniture() {
        return armchair;
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
