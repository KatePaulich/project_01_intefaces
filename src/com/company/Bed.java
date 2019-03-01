package com.company;

public class Bed implements IntFurnitureOneParam {
    String bed = new String();
    double size = 0;

    public Bed(double size){
        this.bed = "Кровать";
        this.size = size;
    }

    @Override
    public String getFutniture() {
        return bed;
    }

    @Override
    public double getSize() {
        return size;
    }
}
