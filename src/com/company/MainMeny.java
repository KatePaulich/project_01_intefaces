package com.company;

import java.util.Scanner;

public class MainMeny {
    Scanner scanner = new Scanner(System.in);
    RoomList roomList = new RoomList();

    public void roomListMeny(){
        System.out.println("Для создания комнаты нажмите - 1");
        System.out.println("Для выбора комнаты из списка нажмите - 2 ");
        System.out.println("Для просмотра инфорации о всех комнатах здания нажмите - 3 ");

        int houseMenyNum = Integer.parseInt(scanner.nextLine());

        if (houseMenyNum == 1){
            roomList.createRoom(scanner);
            roomListMeny();
        }
        if(houseMenyNum == 2){
            findRoomInList(scanner);
            roomListMeny();
        }
        if (houseMenyNum == 3){
            for (Room room: roomList.getRoomList()){
                room.roomInformation(scanner, 0);
            }
            roomListMeny();
        }

    }

    private void findRoomInList(Scanner scanner){
        if (roomList.getRoomList().isEmpty() ){
            System.out.println("Список комнат пуст");
            roomListMeny();
        }else {
            System.out.println("Список комнат:");
            for (Room room: roomList.getRoomList()){
                System.out.println(room.getNameRoom());
            }
        }
        System.out.println("Укаките название комнаты, которую вы хотите просмотреть: ");
        String nameRoom = scanner.nextLine();

        int notCor = 0;
        for (Room room: roomList.getRoomList()){
            if (room.getNameRoom().equals(nameRoom)){
                notCor++;
            }
        }
        if (notCor == 0){
            System.out.println("Вы ввели некорректные данные");
            findRoomInList(scanner);
        }
        for (Room room: roomList.getRoomList()){
            if (room.getNameRoom().equals(nameRoom)){
                room.roomMeny(scanner);
            }
        }
    }
}
