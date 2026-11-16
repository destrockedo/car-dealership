
package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

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

            Scanner scanner = new Scanner(System.in);
            boolean running = true;


            while (running) {
                System.out.print("What can I do for you today? > ");
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


                int input = scanner.nextInt();
                try {

                switch (input) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processGetAllVehiclesRequest();
                    case 8 -> processAddVehicleRequest();
                    case 9 -> processRemoveVehicleRequest();
                    case 99 -> running = false;
                    default -> System.out.println("Invalid option");
                }
            } catch(Exception e){
                System.out.println("Error 404 :( " + e.getMessage());
                scanner.nextLine();
                scanner.close();
            }
        }
    }


    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }
}
