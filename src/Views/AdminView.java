package Views;

import Composite.GroupedShipment;
import Composite.IndividualShipment;
import Composite.ShipmentComponent;
import Composite.ShipmentManager;
import Observer.Observer;
import Services.ShipmentDetails.OrderState;

import java.util.Scanner;


public class AdminView implements Observer {
    static Scanner input = new Scanner(System.in);
    public void showAllShipments(ShipmentManager shipmentManager) {
        System.out.println("Displaying all shipments:");
        shipmentManager.displayAllShipments();
    }

    public void createShipmentOption(ShipmentManager shipments) {
        System.out.println("Select Shipment Type:");
        System.out.println("1. Individual Shipment");
        System.out.println("2. Grouped Shipment");
        int choice = input.nextInt();
        input.nextLine();

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
        System.out.print("Enter User Phone Number: ");
        String phoneNumber = input.next();
        ShipmentComponent shipment = new IndividualShipment(weight,origin,destination,carrier,phoneNumber);
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
    public void searchShipments(ShipmentManager shipmentManager) {
        System.out.print("Enter the ID of the shipment to search for: ");
        String id = input.nextLine();
        shipmentManager.searchShipmentById(id);
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

    @Override
    public void update(OrderState state) {
        System.out.println("Admin status for shipment Changed" );
    }
}
