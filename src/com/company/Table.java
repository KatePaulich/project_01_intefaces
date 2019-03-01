package com.company;

public class Table implements IntFurnitureOneParam {
    String table = new String();
    double size = 0;

    public Table(double maxSize){
        this.table = "Стол";
        this.size = maxSize;
    }


    @Override
    public String getFutniture() {
        return table;
    }

    @Override
    public double getSize() {
        return size;
    }
}
