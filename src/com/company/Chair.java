package com.company;

public class Chair implements IntFurnitureOneParam {
    String chair = new String();
    double size = 0;

    public Chair(double size){
        this.chair = "Стул";
        this.size = size;
    }


    @Override
    public String getFutniture() {
        return chair;
    }

    @Override
    public double getSize() {
        return size;
    }
}

