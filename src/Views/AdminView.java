package Views;

import Composite.ShipmentComponent;
import Composite.ShipmentManager;
import Model.Shipment;
import Services.ShipmentDetails.CancelledState;
import Services.ShipmentDetails.DeliveredState;
import Services.ShipmentDetails.ShippedState;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    static Scanner input = new Scanner(System.in);
    private ShipmentManager shipmentManager;
    //System.out.println("1. Update shipment Status ");
    //System.out.println("2. See All shipments");
    // updating the shipment status is not done
    // seeing all the shipment is not done
    // mostly the admin view and process method is not done

    public void displayOptions() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Shipments");
            System.out.println("2. Add New Shipment");
            System.out.println("3. Remove Shipment by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    shipmentManager.displayAllShipments();
                    break;
                case 2:
                    addNewShipment();  // To be implemented
                    break;
                case 3:
                    removeShipment();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    private void removeShipment() {
        System.out.print("Enter the ID of the shipment to remove: ");
        String shipmentId = input.nextLine();

        boolean removed = shipmentManager.removeShipmentById(shipmentId);
        if (removed) {
            System.out.println("Shipment removed successfully.");
        } else {
            System.out.println("No shipment found with the given ID.");
        }
    }


    private void addNewShipment() {
        // Implement based on specific requirements
        // This could involve interacting with `IndividualShipment` or `GroupedShipment`
        System.out.println("Adding new shipment... (functionality not yet implemented)");
    }


    /*public void updateShipmentStatus(ShipmentManager shipments) {
        System.out.println("what is the ID for the shipment you want to update?");
        String id = input.nextLine();

        *//*for (ShipmentManager shipment : shipments) {
            if (shipment.getId().equalsIgnoreCase(id)) {
                while (true) {
                    System.out.println("What type of Update do you want ?\n" +
                            "- Shipped. \n" +
                            "- Delivered. \n" +
                            "- Cancelled. ");
                    String type = input.nextLine();
                    if (type.equalsIgnoreCase("Shipped")) {
                        //shipment.context.setState(new ShippedState());
                        shipment.context.shipOrder();

                        return;
                    } else if (type.equalsIgnoreCase("Delivered")) {
                        shipment.context.deliverOrder();
                        //shipment.context.setState(new DeliveredState());
                        ;
                        return;
                    } else if (type.equalsIgnoreCase("Cancelled")) {
                        //shipment.context.setState(new CancelledState());
                        shipment.context.cancelOrder();

                        return;
                    } else {
                        System.out.println("Invalid type, please try again.");
                    }
                }
            }

        }
        System.out.println("Invalid id ");*//*

    }*/
    public void updateShipmentStatus(ShipmentManager shipments) {
        System.out.println("What is the ID for the shipment you want to update?");
        String id = input.nextLine();

        ShipmentComponent shipment = shipments.findShipmentById(id);
        if (shipment != null) {
            while (true) {
                System.out.println("What type of update do you want?\n" +
                        "- Shipped\n" +
                        "- Delivered\n" +
                        "- Cancelled");
                String type = input.nextLine();
                switch (type.toLowerCase()) {
                    case "shipped":
                        shipment.getContext().shipOrder(); // Assuming getContext() returns the context
                        System.out.println("Shipment status updated to shipped.");
                        return;
                    case "delivered":
                        shipment.getContext().deliverOrder();
                        System.out.println("Shipment status updated to delivered.");
                        return;
                    case "cancelled":
                        shipment.getContext().cancelOrder();
                        System.out.println("Shipment status updated to cancelled.");
                        return;
                    default:
                        System.out.println("Invalid type, please try again.");
                }
            }
        } else {
            System.out.println("Invalid ID, no shipment found.");
        }
    }


}
