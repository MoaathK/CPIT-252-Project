package Views;

import Model.Shipment;
import Services.ShipmentDetails.CancelledState;
import Services.ShipmentDetails.DeliveredState;
import Services.ShipmentDetails.ShippedState;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    static Scanner input = new Scanner(System.in);

    //System.out.println("1. Update shipment Status ");
    //System.out.println("2. See All shipments");
    // updating the shipment status is not done
    // seeing all the shipment is not done
    // mostly the admin view and process method is not done
    public void updateShipmentStatus(List<Shipment> shipments) {
        System.out.println("what is the ID for the shipment you want to update?");
        String id = input.nextLine();

        for (Shipment shipment : shipments) {
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
        System.out.println("Invalid id ");

    }
    
}
