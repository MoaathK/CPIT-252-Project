package Views;

import Composite.ShipmentComponent;
import Composite.ShipmentManager;

import java.util.Scanner;

public class CarrierView {
    private String carrierName;
    static Scanner input = new Scanner(System.in);

    //System.out.println("1. Update shipment Status ");
    //System.out.println("2. See All shipments");
    // updating the shipment status is not done
    // seeing all the shipment is not done
   public void carrierMenu(ShipmentManager  shipmentManager){
       System.out.println("Enter the carrier name: ");
       carrierName = input.nextLine();
       boolean flag = true;
       while (flag){
           System.out.println("--- Carrier Menu ---");
           System.out.println("1. Update shipment Status ");
           System.out.println("2. See All shipments");
           System.out.println("3. Return to Main Menu");

           System.out.println("Enter your choice");
           int choice = Integer.parseInt(input.nextLine());
           switch(choice){
               case 1:{
                   updateShipmentStatus(shipmentManager);
                   break;
               }
               case 2:{
                   showAllShipments(shipmentManager);
                   break;
               }
               case 3:{
                   System.out.println("Returning to Main Menu");
                   return;
               }
               default:{
                   System.out.println("Invalid Option, Please enter a valid choice");
               }
           }
           System.out.println("Want to see the Carrier menu again? (Y/N)");
           String answer = input.nextLine();
           if (answer.equalsIgnoreCase("N")){
               flag = false;
           }
       }
   }


   /* private void removeShipment() {
        System.out.print("Enter the ID of the shipment to remove: ");
        String shipmentId = input.nextLine();

        //boolean removed = shipmentManager.removeShipmentById(shipmentId);
        if (removed) {
            System.out.println("Shipment removed successfully.");
        } else {
            System.out.println("No shipment found with the given ID.");
        }
    }*/


    private void addNewShipment() {
        // Implement based on specific requirements
        // This could involve interacting with `IndividualShipment` or `GroupedShipment`
        System.out.println("Adding new shipment... (functionality not yet implemented)");
    }


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
                        shipment.getContext().shipOrder();
                        return;
                    case "delivered":
                        shipment.getContext().deliverOrder();
                        return;
                    case "cancelled":
                        shipment.getContext().cancelOrder();
                        return;
                    default:
                        System.out.println("Invalid type, please try again.");
                }
            }
        } else {
            System.out.println("Invalid ID, no shipment found.");
        }
    }
    public void showAllShipments(ShipmentManager  shipmentManager) {

        shipmentManager.displayShipmentBasedOnCarrier(carrierName);


    }


}
