package Views;

import Model.InternationalShipmentBuilder;
import Model.LocalShipmentBuilder;
import Model.Shipment;
import Model.ShipmentBuilder;

import java.util.List;
import java.util.Scanner;


public class UserView {
    static Scanner input = new Scanner(System.in);
    //private static List<Shipment> shipments1 = new ArrayList<>();
    public void userAddShipmentView(List<Shipment> shipments){

        while (true){
            System.out.println("Please select the type of shipment:");
            System.out.println("1. Local Shipment");
            System.out.println("2. International Shipment");
            System.out.println("3. Return to User menu");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:{
                    createLocalShipment(shipments);
                    return;

                }
                case 2:{
                    createInternationalShipment(shipments);
                    return;
                }
                case 3:{
                    System.out.println("returning to User menu ..");
                    return;
                }
                default:{
                    System.out.println("Invalid Option, Please enter a valid choice");
                }

            }
        }
    }
    public void printAllShipments(List<Shipment> shipments){
        if(!shipments.isEmpty()) {
            for (Shipment shipment : shipments) {
                System.out.println(shipment.toString());
                System.out.println("-------------------------");
            }
        }
        else
            System.out.println("No shipments found");
    }
    public void removeShipment(List<Shipment> shipments) {
        System.out.println("Please enter the id of the shipment You want to remove:");
        String id = input.nextLine();
        for (Shipment shipment : shipments) {
            if (shipment.getId().equalsIgnoreCase(id)) {
                shipments.remove(shipment);
                System.out.println("Shipment removed");
                return;
            }

        }
        System.out.println("Shipment not found with this id"+id);
    }
    public void userCheckOrderInfoById(List<Shipment> shipments){
        System.out.print("Enter the ID of the shipment you want to find: ");
        String id = input.nextLine();
        for (Shipment shipment : shipments) {
            if ( shipment.getId().equalsIgnoreCase( id ) ) {

                System.out.println(shipment.toString());
                System.out.println("Shipment State"); //here we connect to the state pattern to get the shipment state
                return;
            }
        }
        System.out.println("No shipment found with ID: " + id);
    }
    private static void setupShipmentBuilder(List<Shipment> shipments) {
        Shipment shipment = new Shipment();
        System.out.println("Enter origin: ");
        String origin = input.nextLine();
        shipment.setOrigin(origin);

        System.out.println("Enter destination: ");
        String destination = input.nextLine();
        shipment.setDestination(destination);

        System.out.println("Enter carrier: (SMSA or Aramex)");
        String carrier = input.nextLine();
        shipment.setCarrier(carrier);

        System.out.println("Enter weight: ");
        double weight = Double.parseDouble(input.nextLine());
        shipment.setWeight(weight);


        shipments.add(shipment);
        System.out.println(shipment);


    }
    private static void createLocalShipment(List<Shipment> shipments) {
        setupShipmentBuilder(shipments);
    }
    private static void createInternationalShipment(List<Shipment> shipments) {
        setupShipmentBuilder(shipments);
    }

}
