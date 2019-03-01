package com.company;

public class Lamp {
    int lightLamp = 0;

    public Lamp(int lightLamp)  //конструктор для создания мощности ламп
    {
        this.lightLamp = lightLamp;
    }

    public int getLightLamp() //метод, который возвращает значение мощности лампочки
    {
        return lightLamp;
    }
}
