package com.company;


import java.util.ArrayList;
import java.util.List;

public class MainClient {

    public static void main(String[] args) {
        // write your code here

        List<Person> personList = new ArrayList<>();

        Person reg = new Person(PersonType.regular);
        Person vip = new Person(PersonType.vip);

        personList.add(reg);
        personList.add(vip);



        ParkingLot parkingLot = new ParkingLot(2, 2, 10);
        Vehicle v  = new Truck();
        Vehicle v1 = new Motorcycle();
        Vehicle v11 = new Motorcycle();
        Vehicle v111 = new Motorcycle();
        Vehicle v2 = new Car();
        Vehicle v22 = new Car();
        Vehicle v222 = new Car();
        Vehicle v3 = new Truck();
        Vehicle v4 = new Truck();


        parkingLot.setPersonList(personList);

        List<Vehicle> lista = new ArrayList<>();

        lista.add(v);
        lista.add(v1);
        lista.add(v11);
        lista.add(v111);
        lista.add(v2);
        lista.add(v22);
        lista.add(v222);
        lista.add(v3);
        lista.add(v4);


        parkingLot.parkVehicle(lista);
//        Vehicle truck = new Vehicle();
//        parkingLot.parkVehicle(truck);
//        parkingLot.unParkVehicle(truck);



        System.out.println();
        System.out.println();
    }
}
