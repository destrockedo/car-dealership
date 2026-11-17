
package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    // Stores the dealership object, allows UserInterface to access its info/vehicles
    private Dealership dealership;

    private void init() {
        //Creates obejcet that can read csv file
        DealershipFileManager fileManager = new DealershipFileManager();
        //calling method to load dealership/ stores loaded dealersh into private Dealership dealership
        dealership = fileManager.getDealership();
    }

    public UserInterface() {

    }

    public void display() {
        //Loads Dealership
        init();


            boolean running = true;


            while (running) {
                System.out.println("What can I do for you today? > ");
                System.out.println("[1] Find Vehicles within a price range");
                System.out.println("[2] Find Vehicles by make/model");
                System.out.println("[3] Find Vehicles by year range");
                System.out.println("[4] Find Vehicles by color");
                System.out.println("[5] Find Vehicles by mileage range");
                System.out.println("[6] Find Vehicles by type (car, truck, SUV, van)");
                System.out.println("[7] List All vehicles");
                System.out.println("[8] Add a vehicle");
                System.out.println("[9] Remove a vehicle");
                System.out.println("[99] Quit");


                try {
                    int input = scanner.nextInt();
                    scanner.nextLine();
                switch (input) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processGetAllVehiclesRequest();
                    case 8 -> processAddVehicleRequest(scanner);
                    case 9 -> processRemoveVehicleRequest();
                    case 99 -> running = false;
                    default -> System.out.println("Invalid option");
                }
            } catch(Exception e){
                System.out.println("Error 404 :( " + e.getMessage());
                scanner.nextLine();
            }
        }
    }


    public void processGetByPriceRequest() {
        //ArrayList<Vehicle> priceVehicles = new ArrayList<>();
        System.out.println("What is your min Price range?");
        BigDecimal priceMin = scanner.nextBigDecimal();
        System.out.println("What is your max Price range?");
        BigDecimal priceMax = scanner.nextBigDecimal();
        scanner.nextLine();

        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            //compareTo only for bigdecimal
            //greater than or equal to the min and less than or equal to the max
            if ((vehicle.getPrice().compareTo(priceMin) >= 0 && vehicle.getPrice().compareTo(priceMax) <=0  )) {
                priceVehicles.add(vehicle);
            }
        }*/
        //displayVehicles(priceVehicles);
        displayVehicles(dealership.getVehiclesByPrice(priceMin, priceMax));
    }

    public void processGetByMakeModelRequest() {
        //ArrayList<Vehicle> MMVehicles = new ArrayList<>();
        System.out.println("What is your preferred Make?");
        String make = scanner.nextLine();
        System.out.println("What is preferred model?");
        String model = scanner.nextLine();
        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            if ((vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model) )) {
                MMVehicles.add(vehicle);
            }
        }*/
        //displayVehicles(MMVehicles);
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        //ArrayList<Vehicle> yearVehicles = new ArrayList<>();
        System.out.println("What is your min Year range?");
        int yearMin = scanner.nextInt();
        System.out.println("What is your max Year range?");
        int yearMax = scanner.nextInt();
        scanner.nextLine();
        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            if((vehicle.getYear() >= yearMin && vehicle.getYear() <= yearMax)) {
                yearVehicles.add(vehicle);

            }
        }*/
        //displayVehicles(yearVehicles);
        displayVehicles(dealership.getVehiclesByYear(yearMin,yearMax));
    }

    public void processGetByColorRequest() {
        //ArrayList<Vehicle> colorVehicles = new ArrayList<>();
        System.out.println("What Color are you searching for today?");
        String color = scanner.nextLine();
        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            if(color.equalsIgnoreCase(vehicle.getColor())) {
               colorVehicles.add(vehicle);
            }
        }*/
        //displayVehicles(colorVehicles);
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        //ArrayList<Vehicle> rangeVehicles = new ArrayList<>();
        System.out.println("What is your min range?");
        int rangeMin = scanner.nextInt();
        System.out.println("What is your max range?");
        int rangeMax = scanner.nextInt();
        scanner.nextLine();
        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            if((vehicle.getOdometer() >= rangeMin && vehicle.getOdometer() <= rangeMax)) {
             rangeVehicles.add(vehicle);

            }
        }*/
        //displayVehicles(rangeVehicles);
        displayVehicles(dealership.getVehiclesByMileage(rangeMin, rangeMax));
    }

    public void processGetByVehicleTypeRequest() {
        //ArrayList<Vehicle> typeVehicles = new ArrayList<>();
        System.out.println("What Type of vehicle are you searching for today?");
        String type = scanner.nextLine();
        /*for (Vehicle vehicle : dealership.getAllVehicles()) {
            if(type.equalsIgnoreCase(vehicle.getVehicleType())) {
                typeVehicles.add(vehicle);

            }
        }*/
        //displayVehicles(typeVehicles);
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Vehicle Vin: ");
                int vin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Vehicle Year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Vehicle Make: ");
                String make = scanner.nextLine();
                System.out.println("Vehicle Model: ");
                String model = scanner.nextLine();
                System.out.println("Type of Vehicle: ");
                String type = scanner.nextLine();
                System.out.println("Vehicle Color: ");
                String color = scanner.nextLine();
                System.out.println("Vehicle Mileage: ");
                int odometer = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Vehicle Price: ");
                BigDecimal price = scanner.nextBigDecimal();
                scanner.nextLine();


                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                //add new vehicle to the arraylist
                dealership.addVehicle(vehicle);

                DealershipFileManager fileManager = new DealershipFileManager();
                //instead of appending the savedealship already writes down arrays list
                fileManager.saveDealership(dealership);
                System.out.println("Vehicle added!");
                break;

                /*
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true))) {

                    writer.newLine();
                    writer.write(vehicle.toString());
                } catch (Exception e) {
                    System.out.println("Error 404 :( " + e.getMessage());
                }*/
            } catch (Exception e) {
                System.out.println("Error 404 :( " + e.getMessage());
            }
        }
    }

    public void processRemoveVehicleRequest() {
        System.out.println("What is the Vin number of the vehicle your removing?");
        int vin = scanner.nextInt();
        scanner.nextLine();

        //Varaible with vehicle object
        Vehicle remove = null;

        for (Vehicle vehicle : dealership.getAllVehicles())
            if (vehicle.getVin() == vin) {
                remove = vehicle;
            }


    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        //Prints all vehicles in array
        for (Vehicle vehicle : vehicles) {
            System.out.println(
                    vehicle.getVin() + " | " + vehicle.getYear() + " | " + vehicle.getMake() + " | " + vehicle.getModel() + " | " +
                            vehicle.getVehicleType() + " | " + vehicle.getColor() + " | " + vehicle.getOdometer() + " | " + vehicle.getPrice());
        }
    }
}
