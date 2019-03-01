package com.company;

import java.util.Scanner;

public class Room {
    private String nameRoom = new String();
    private double square = 0;
    private int colWindow = 0;
    private LampList lampList;
    private ArmchairList armchairList;
    private BedList bedList;
    private ChairList chairList;
    private TableList tableList;
    private SofaList sofaList;

    public Room(String nameRoom, double square, int colWindow, LampList lampList,
                ArmchairList armchairList, BedList bedList, TableList tableList,
                ChairList chairList, SofaList sofaList){ //метод для создания комнаты
        this.nameRoom = nameRoom;
        this.square = square;
        this.colWindow = colWindow;
        this.lampList = lampList;
        this.chairList = chairList;
        this.armchairList = armchairList;
        this.sofaList = sofaList;
        this.tableList = tableList;
        this.bedList = bedList;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public double getSquare() {
        return square;
    }

    public void setColWindow(int colWindow) {
        this.colWindow = colWindow;
    }

    public void roomInformation(Scanner scanner, int where){
        System.out.println("Информация о следующей комнате: " + nameRoom);
        System.out.println("Площадь комнаты составляет: "+ square);
        System.out.println("Количество окон(каждое 700лк): " + colWindow);
        int light = 0;
        for (Lamp lamp: lampList.getLampLists()){
            System.out.println("Лампочки по " + lamp.getLightLamp()+" лк");
            light += lamp.getLightLamp();
        }
        System.out.println("Освещенность комнаты: "+ (light+colWindow*700));
        System.out.println("Список мебели:");
        if (armchairList.getArmchairList().isEmpty() && bedList.getBedList().isEmpty()
                && sofaList.getSofaList().isEmpty() && chairList.getChairList().isEmpty()
                && tableList.getTableList().isEmpty()){
            System.out.println("В этой комнате пока нет мебели");
        }
        double squareMax = 0;
        for (Sofa sofa: sofaList.getSofaList()){
            squareMax += sofa.maxSize;
            System.out.println(sofa.sofa+ " занимаемая площадь: " + sofa.maxSize + " m^2");
        }
        for (Armchair armchair: armchairList.getArmchairList()){
            squareMax += armchair.maxSize;
            System.out.println(armchair.armchair+ " занимаемая площадь: " + armchair.maxSize + " m^2");
        }
        for (Bed bed: bedList.getBedList()){
            squareMax += bed.size;
            System.out.println(bed.bed+ " занимаемая площадь: " + bed.size + " m^2");
        }
        for (Chair chair: chairList.getChairList()){
            squareMax += chair.size;
            System.out.println(chair.chair+ " занимаемая площадь: " + chair.size + " m^2");
        }
        for (Table table: tableList.getTableList()){
            squareMax += table.size;
            System.out.println(table.table+ " занимаемая площадь: " + table.size + " m^2");
        }
        System.out.println("Занято площади: " + squareMax * 100/square + "%");


        System.out.println("Для продолжения нажмите на клавишу enter...");
        scanner.nextLine();
        if (where == 1) {
            roomMeny(scanner);
        }
    }

    public void  roomMeny(Scanner scanner){
        System.out.println("Вы находитесь в комнате: "+ nameRoom);
        System.out.println("Для просмотра информации о комнате нажмите - 1");
        System.out.println("Для добавления мебели нажмите - 2");
        System.out.println("Для добавления осветительного прибора - 3");
        System.out.println("Для выхода в предыдущее меню нажмите - 0");


        int roomMenyNumb = Integer.parseInt(scanner.nextLine());

        if (roomMenyNumb == 1){
            roomInformation(scanner,1);
        }
        if (roomMenyNumb == 2){
            addFurniture(scanner);
        }
        if (roomMenyNumb == 3){
            addLight(scanner);
            roomMeny(scanner);
        }
        if (roomMenyNumb == 0){
            return;
        }
    }

    private void addFurniture(Scanner scanner){
        System.out.println("Добавление мебели: ");
        System.out.println("Добавить диван - 1");
        System.out.println("Добавить стол - 2");
        System.out.println("Добавить кресло - 3");
        System.out.println("Добавить кровать - 4");
        System.out.println("Добавить стул - 5");
        System.out.println("Выйти из данного меню - 0");


        int addFurnitureNumb = Integer.parseInt(scanner.nextLine());

        if (addFurnitureNumb == 0){
            roomMeny(scanner);
        }
        if (addFurnitureNumb == 1){
            System.out.println("Вы перешли в пункт добавления дивана");
            System.out.println("Введите минимально занимаемую площадь:");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите максимально занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (addFurnitureToRoom(maxSize) == 0) {
                sofaList.addSofa(new Sofa(minSize, maxSize));
            }
            addFurniture(scanner);
        }
        if (addFurnitureNumb == 2){
            System.out.println("Вы перешли в пункт добавления стола");
            System.out.print("Введите  занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (addFurnitureToRoom(maxSize) == 0) {
                tableList.addTable(new Table(maxSize));
            }
            addFurniture(scanner);
        }
        if (addFurnitureNumb == 3){
            System.out.println("Вы перешли в пункт добавления кресла");
            System.out.print("Введите минимально занимаемую площадь: ");
            double minSize = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите максимально занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (addFurnitureToRoom(maxSize) == 0){
                armchairList.addArmchair(new Armchair(minSize,maxSize));
            }
            addFurniture(scanner);
        }
        if (addFurnitureNumb == 4){
            System.out.println("Вы перешли в пункт добавления кровати");
            System.out.print("Введите  занимаемую площадь: ");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (addFurnitureToRoom(maxSize) == 0){
                bedList.addBed(new Bed(maxSize));
            }
            addFurniture(scanner);
        }
        if (addFurnitureNumb == 5){
            System.out.println("Вы перешли в пункт добавления стула");
            System.out.println("Введите  занимаемую площадь:");
            double maxSize = Double.parseDouble(scanner.nextLine());
            if (addFurnitureToRoom(maxSize) == 0){
                chairList.addChair(new Chair(maxSize));
            }
            addFurniture(scanner);
        }
    }

    public int addFurnitureToRoom(double furnitureSquare){
        double squareMax = 0;
        for (Sofa sofa: sofaList.getSofaList()){
            squareMax += sofa.maxSize;
        }
        for (Armchair armchair: armchairList.getArmchairList()){
            squareMax += armchair.maxSize;
        }
        for (Bed bed: bedList.getBedList()){
            squareMax += bed.size;
        }
        for (Chair chair: chairList.getChairList()){
            squareMax += chair.size;
        }
        for (Table table: tableList.getTableList()){
            squareMax += table.size;
        }
        squareMax += furnitureSquare;
        if (squareMax*100/square >70){
            System.out.println("WrongSpaceException(Занято больше 70% комнаты!)");
            return 1;
        }
        return  0;
    }

    public void addLight(Scanner scanner){
        System.out.print("Введите мощность лампочки: ");
        Lamp lampNew = new Lamp(Integer.parseInt(scanner.nextLine()));
        int summLightFlow = 0;
        for (Lamp lamp: lampList.getLampLists()){
            summLightFlow += lamp.getLightLamp();
        }
        summLightFlow +=  colWindow * 700;
        if (summLightFlow + lampNew.getLightLamp() > 4000){
            System.out.println("WrongIlluminanceException(Слишком много света, нужно меньше окон)");
        }else {
            lampList.addLampList(lampNew);
        }
        return;
    }
}
