package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }
    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
        ArrayList<Vehicle> matchingVPrice = new ArrayList<>();

        //Can access all vehicles directly so dont need get all vehicles
        for (Vehicle vehicle : vehicles) {
            //compareTo only for bigdecimal
            //greater than or equal to the min and less than or equal to the max
            if ((vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <=0  )) {
                matchingVPrice.add(vehicle);
            }
        }

        return matchingVPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> matchingVMM = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if ((vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model) )) {
                matchingVMM.add(vehicle);
            }
        }
        return matchingVMM;
    }


    public ArrayList<Vehicle> getVehiclesByYear(int yearMin, int yearMax){
        ArrayList<Vehicle> matchingVYear = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if((vehicle.getYear() >= yearMin && vehicle.getYear() <= yearMax)) {
                matchingVYear.add(vehicle);
            }
        }

        return matchingVYear;}

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> matchingVColor = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if(color.equalsIgnoreCase(vehicle.getColor())) {
                matchingVColor.add(vehicle);
            }
        }

        return matchingVColor;}

    public ArrayList<Vehicle> getVehiclesByMileage(int rangeMin, int rangeMax){
        ArrayList<Vehicle> matchingVmileage = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if((vehicle.getOdometer() >= rangeMin && vehicle.getOdometer() <= rangeMax)) {
                matchingVmileage.add(vehicle);

            }
        }
        return matchingVmileage;}

    public ArrayList<Vehicle> getVehiclesByType(String type){
        ArrayList<Vehicle> matchingVtype = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if(type.equalsIgnoreCase(vehicle.getVehicleType())) {
                matchingVtype.add(vehicle);

            }
        }
        return matchingVtype;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addVehicle (Vehicle vehicle){vehicles.add(vehicle);}

    public void removeVehicle(Vehicle vehicle){}

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }
}
