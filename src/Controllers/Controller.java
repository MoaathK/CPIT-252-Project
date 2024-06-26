package Controllers;

import Composite.ShipmentComponent;
import Composite.ShipmentManager;
import Services.ShipmentDetails.OrderContext;
import Views.CarrierView;
import Views.AdminView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private AdminView view1;
    private CarrierView view2;
    Scanner input = new Scanner(System.in);
    private static final List<ShipmentComponent> shipments = new ArrayList<>();
    private ShipmentManager shipmentManager;
    private OrderContext orderContext;
    public Controller() {
        this.shipmentManager = new ShipmentManager();
        this.view1 = new AdminView();
        this.view2 = new CarrierView();
        orderContext = new OrderContext();
        orderContext.attach(view1);
        orderContext.attach(view2);

    }
    public void view0 (){
        while (true){
            System.out.println("welcome to the Transport Management System (TMS)\n"
                                +"----Main Menu-----");
            System.out.println("Type ( 0 ) to Exit ");
            System.out.println("Are you a 'Admin' or an 'Carrier'? Enter your role:");
            String role = input.nextLine();
            if (role.equalsIgnoreCase("Admin")){
                adminMenu();
                orderContext.notifyObservers();
            }
            else if (role.equalsIgnoreCase("Carrier")){
                view2.carrierMenu(shipmentManager);
            }
            else if (role.equals("0")){
                System.exit(0);
            }
            else {
                System.out.println("Invalid input, please try again");
            }

        }
    }

    public void adminMenu(){
        boolean flag = true;
        while (flag){
            System.out.println("--- Admin Menu ---");
            System.out.println("1. Add new shipment ");
            System.out.println("2. Remove shipment ");
            System.out.println("3. Search shipment by ID");
            System.out.println("4. See All shipments");
            System.out.println("5. Return to Main Menu");

            System.out.println("Enter your choice");
            int choice = Integer.parseInt(input.nextLine());
            input.nextLine();
            switch(choice){
                case 1:{
                    view1.createShipmentOption(shipmentManager);
                    break;
                }
                case 2:{

                    view1.removeShipment(shipmentManager);
                    break;
                }
                case 3:{
                    view1.searchShipments(shipmentManager);
                    break;
                }
                case 4:{
                    view1.showAllShipments(shipmentManager);
                    break;
                }
                case 5:{
                    System.out.println("Returning to Main Menu");
                    return;
                }
                default:{
                    System.out.println("Invalid Option, Please enter a valid choice");
                }
            }
            System.out.println("Want to see the User menu again? (Y/N)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("n")){
                flag = false;
            }
            input.nextLine();

        }

    }




}
