package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;


public class DealershipFileManager {

    public Dealership getDealership() {


        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;

            line = reader.readLine();
            String[] parts = line.split("\\|");

            String name = parts[0];
            String address = parts[1];
            String phone = parts[2];

            Dealership dealership = new Dealership(name, address, phone);

            //Orginally Had +1 for Dealership but readerLine automatically reads next line
            while ((line = reader.readLine()) != null) {
                parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                BigDecimal price = new BigDecimal(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }

            return dealership;

        } catch (IOException e) {
            System.out.println("Error 440" + e.getMessage());
        }

        return null;
    }

    public void saveDealership(Dealership dealership) {

    }
}