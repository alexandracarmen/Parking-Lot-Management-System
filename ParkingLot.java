package com.company;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<SmallSpot> smallSpotList = new ArrayList<>();
    private List<MediumSpot> mediumSpotList = new ArrayList<>();
    private List<LargeSpot> largeSpotList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();

    int freeSmallSpots;
    int freeMediumSpots;
    int freeLargeSpots;
    private Vehicle vehicle;

    public ParkingLot(int freeSmallSpots, int freeMediumSpots, int freeLargeSpots) {
        this.freeSmallSpots = freeSmallSpots;
        this.freeMediumSpots = freeMediumSpots;
        this.freeLargeSpots = freeLargeSpots;
    }

    //parkVehicle
    public void parkVehicle(List<Vehicle> vehicle) {
        for(int p = 0 ; p < personList.size() ; ++p){
            if(personList.get(p).getPersonType().equals(PersonType.regular)) {
                for (int i = 0; i < vehicle.size(); ++i) {

                    System.out.println("We are about to park your Vehicle of type" + vehicle.get(i).getVehicleType());


                    if (vehicle.get(i).getVehicleType().equals(VehicleType.TRUCK)) {
                        if (freeLargeSpots > 0)
                            parkYourLargeVehicle(vehicle.get(i));
                        else
                            System.out.println("Sorry, all large spots are full");


                    } else if (vehicle.get(i).getVehicleType().equals(VehicleType.CAR)) {
                        if (freeMediumSpots > 0)
                            parkYourMediumVehicle(vehicle.get(i));
                        else
                            System.out.println("Sorry, tha park is full");


                    } else if (vehicle.get(i).getVehicleType().equals(VehicleType.MOTORCYCLE)) {
                        if (freeSmallSpots > 0)
                            parkYourSmallVehicle(vehicle.get(i));
                        else
                            System.out.println("Sorry, tha park is full");


                    }
                }
            }

            else if(personList.get(p).getPersonType().equals(PersonType.vip)){
                System.out.println("**********************************************");
                for (int i = 0; i < vehicle.size(); ++i) {

                    System.out.println("We are about to park your VIPPP Vehicle of type" + vehicle.get(i).getVehicleType());


                    if (vehicle.get(i).getVehicleType().equals(VehicleType.TRUCK)) {
                        if (freeLargeSpots > 0)
                            parkYourLargeVehicle(vehicle.get(i));
                        else
                            System.out.println("Sorry, all large spots are full FOR VIP");


                    } else if (vehicle.get(i).getVehicleType().equals(VehicleType.CAR)) {
                        if (freeMediumSpots > 0)
                            parkYourMediumVehicle(vehicle.get(i));
                        else if(freeLargeSpots > 0)
                            parkYourLargeVehicle(vehicle.get(i));


                    } else if (vehicle.get(i).getVehicleType().equals(VehicleType.MOTORCYCLE)) {
                        if (freeSmallSpots > 0)
                            parkYourSmallVehicle(vehicle.get(i));
                        else if( freeMediumSpots > 0)
                            parkYourMediumVehicle(vehicle.get(i));
                        else if (freeLargeSpots > 0)
                            parkYourLargeVehicle(vehicle.get(i));


                    }
                }


            }
        }
    }

    private void parkYourSmallVehicle(Vehicle vehicle) {
        SmallSpot smallSpot = new SmallSpot(ParkingSpotType.SMALL);
        smallSpot.setFree(false);
        smallSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(smallSpot);

        smallSpotList.add(smallSpot);
        System.out.println("We have successfully parked" + vehicle.getVehicleType());
        freeSmallSpots--;
    }

    private void parkYourMediumVehicle(Vehicle vehicle) {
        MediumSpot mediumSpot = new MediumSpot(ParkingSpotType.MEDIUM);
        mediumSpot.setFree(false);
        mediumSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(mediumSpot);

        mediumSpotList.add(mediumSpot);
        System.out.println("We have successfully parked" + vehicle.getVehicleType());
        freeMediumSpots--;
    }

    private void parkYourLargeVehicle(Vehicle vehicle) {
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotList.add(largeSpot);
        System.out.println("We have successfully parked" + vehicle.getVehicleType());
        freeLargeSpots--;
    }

    //UnparkVehicle

    public void unParkVehicle(Vehicle vehicle) {
        System.out.println("we are about to Unpark or remove your Vehicle of type" + vehicle.getVehicleType());
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);

        if (vehicle.getVehicleType().equals(VehicleType.MOTORCYCLE)) {
            if (largeSpotList.remove(vehicle)) {
                System.out.println("We have successfully removed your Vehicle");
                freeSmallSpots++;
            } else
                System.out.println("You dont have your vehicle parked at this parking lot");

        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            if (mediumSpotList.remove(vehicle)) {
                System.out.println("We have successfully removed your Vehicle");
                freeMediumSpots++;
            } else
                System.out.println("You dont have your vehicle parked at this parking lot");
        } else if (vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
            if (largeSpotList.remove(vehicle)) {
                System.out.println("We have successfully removed your Vehicle");
                freeLargeSpots++;
            } else
                System.out.println("You dont have your vehicle parked at this parking lot");
        }
    }

    public List<Person> getPersonList(){
        return this.personList;
    }
    public void setPersonList(List<Person> p){
        this.personList = p;
    }


}
