package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomList {
    private List<Room> roomList;

    public RoomList(){
        roomList = new ArrayList<>();
    }

    public void addRoomToList(Room room) {
        roomList.add(room);
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    private LampList lampList = new LampList();

    public void createRoom(Scanner scanner) {
        System.out.println("Введите название комнаты");
        String nameRoom = scanner.nextLine();
        System.out.println("Введи ее площадь");
        Double square = Double.parseDouble(scanner.nextLine());
        System.out.println("Сколько окон будет в твоем помещении?");
        int colWindow = Integer.parseInt(scanner.nextLine());
        while (colWindow > 5) {
            System.out.println("WrongIlluminanceException(Слишком много света, нужно меньше окон)");
            System.out.println("Окон не должно быть больше 5. Введите количетсво окон");
            colWindow = Integer.parseInt(scanner.nextLine());
        }
        int maxLamp = 0;
        if (colWindow == 0) {
            System.out.println("Тогда нужно добавить лампочки! Без света никак!");
            while (maxLamp < 300) {
                maxLamp = 0;
                System.out.println("Введите мощность лампочки!");
                int lightLamp = Integer.parseInt(scanner.nextLine());

                for (Lamp lamp : lampList.getLampLists()) { //ходим по всему списку
                    maxLamp += lamp.getLightLamp();
                }
                if (maxLamp + lightLamp > 4000) {
                    System.out.println("WrongIlluminanceException(Слишком много света, нужно меньше лампочек)");
                } else {
                    lampList.addLampList(new Lamp(lightLamp)); //добавляем лампочку в список
                    maxLamp += lightLamp;
                }
            }
        }
        System.out.println("Хотите добавить лампочки?!");
        System.out.println("Да - 1");
        System.out.println("Нет - 2");
        int chLamp = Integer.parseInt(scanner.nextLine());
        if (chLamp == 1) {
            maxLamp = 0;
            System.out.println("Введите мощность лампочки");
            int lightLamp = Integer.parseInt(scanner.nextLine());

            for (Lamp lamp : lampList.getLampLists()) { //ходим по всему списку
                maxLamp += lamp.getLightLamp();
            }
            if (maxLamp + lightLamp + colWindow * 700 > 4000) {
                System.out.println("WrongIlluminanceException(Слишком много света, нужно меньше лампочек)");
            } else {
                lampList.addLampList(new Lamp(lightLamp)); //добавляем лампочку в список
                maxLamp += lightLamp;
            }
        }
        if (chLamp == 2) {
            System.out.println("Если не хотите, то и ладно");
        }
        Room room = new Room(nameRoom,square,colWindow,lampList, new ArmchairList(),
                new BedList(),new TableList(), new ChairList(), new SofaList());
        addRoomToList(room);
        room.roomMeny(scanner);
    }



}