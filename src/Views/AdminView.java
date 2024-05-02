package Views;

import Model.Shipment;

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

        System.out.println("Enter shipment status");
        String status = input.nextLine();

    }

}
