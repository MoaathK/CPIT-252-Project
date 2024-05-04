package Views;

import Composite.GroupedShipment;
import Composite.IndividualShipment;
import Composite.ShipmentComponent;
import Composite.ShipmentManager;
import Model.InternationalShipmentBuilder;
import Model.LocalShipmentBuilder;
import Model.Shipment;
import Model.ShipmentBuilder;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class UserView {
    static Scanner input = new Scanner(System.in);
    //private static List<Shipment> shipments1 = new ArrayList<>();

    /*public void userAddShipmentView(List<Shipment> shipments){

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
    }*/
    public void showAllShipments(ShipmentManager shipmentManager) {
        System.out.println("Displaying all shipments:");
        shipmentManager.displayAllShipments();
    }
    /*public void printAllShipments(List<Shipment> shipments){
        if(!shipments.isEmpty()) {
            for (Shipment shipment : shipments) {
                System.out.println(shipment.toString());
                System.out.println("-------------------------");
            }
        }
        else
            System.out.println("No shipments found");
    }*/
    /*public void removeShipment(List<Shipment> shipments) {
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
    }*/
    /*public void userCheckOrderInfoById(List<Shipment> shipments){
        System.out.print("Enter the ID of the shipment you want to find: ");
        String id = input.nextLine();
        for (Shipment shipment : shipments) {
            if ( shipment.getId().equalsIgnoreCase( id ) ) {

                System.out.println(shipment.toString());
                System.out.println(shipment.context.getState());
                System.out.println("Shipment State"); //here we connect to the state pattern to get the shipment state
                return;
            }
        }
        System.out.println("No shipment found with ID: " + id);
    }*/
    /*private static void setupShipmentBuilder(List<Shipment> shipments) {
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


    }*/
   /* private static void createLocalShipment(List<Shipment> shipments) {
        setupShipmentBuilder(shipments);
    }
    private static void createInternationalShipment(List<Shipment> shipments) {
        setupShipmentBuilder(shipments);
    }*/
    public void createShipmentOption(ShipmentManager shipments) {
        System.out.println("Select Shipment Type:");
        System.out.println("1. Individual Shipment");
        System.out.println("2. Grouped Shipment");
        int choice = input.nextInt();
        input.nextLine(); // consume newline

        if (choice == 1) {
            createIndividualShipment(shipments);
        } else if (choice == 2) {
            createGroupedShipment(shipments);
        } else {
            System.out.println("Invalid choice.");
        }
    }
    private void createIndividualShipment(ShipmentManager shipments) {

        System.out.print("Enter origin: ");
        String origin = input.next();
        System.out.print("Enter destination: ");
        String destination = input.next();
        System.out.print("Enter carrier(SMSA or Aramex): ");
        String carrier = input.next();
        System.out.print("Enter weight: ");
        double weight = input.nextDouble();
        ShipmentComponent shipment = new IndividualShipment(weight,origin,destination,carrier);
        shipments.setShipment(shipment);
        shipment.displayShipmentDetails();
    }
    private void createGroupedShipment(ShipmentManager shipments) {
        GroupedShipment group = new GroupedShipment();
        String more;
        do {
            System.out.println("Adding a shipment to the group:");
            createIndividualShipment(shipments);
            System.out.println("Add more shipments to the group? (yes/no)");
            more = input.next();
        } while (more.equalsIgnoreCase("yes"));
        group.displayShipmentDetails();
    }
    public void searchShipments(List<ShipmentComponent> allShipments) {
        System.out.print("Enter search criteria (id, origin, destination, carrier): ");
        String criteria = input.nextLine();
        System.out.print("Enter search value: ");
        String value = input.nextLine();

        List<ShipmentComponent> results = allShipments.stream()
                .filter(shipment -> shipment.matchesSearchCriteria(criteria, value))
                .toList();
        /*
        List<ShipmentComponent> results = allShipments.stream()
                .filter(shipment -> shipment.matchesSearchCriteria(criteria, value))
                .collect(Collectors.toList());
         */

        if (results.isEmpty()) {
            System.out.println("No shipments found matching the criteria.");
        } else {
            System.out.println("Shipments matching your criteria:");
            results.forEach(ShipmentComponent::displayShipmentDetails);
        }
    }
    public void removeShipment(ShipmentManager shipmentManager) {
        System.out.print("Enter the ID of the shipment to remove: ");
        String shipmentId = input.nextLine();

        boolean removed = shipmentManager.removeShipmentById(shipmentId);
        if (removed) {
            System.out.println("Shipment removed successfully.");
        } else {
            System.out.println("No shipment found with the given ID.");
        }
    }
}
