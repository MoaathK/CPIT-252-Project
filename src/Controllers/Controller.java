package Controllers;

import Composite.ShipmentComponent;
import Composite.ShipmentManager;
import Views.AdminView;
import Views.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private UserView view1;
    private AdminView view2;
    Scanner input = new Scanner(System.in);
    private static final List<ShipmentComponent> shipments = new ArrayList<>();
    private ShipmentManager shipmentManager;

    public Controller() {
        this.shipmentManager = new ShipmentManager();
        this.view1 = new UserView();
        this.view2 = new AdminView();
    }
    public void view0 (){
        while (true){

            System.out.println("welcome to the Transport Management System (TMS)\n"
                                +"----Main Menu-----");
            System.out.println("Type ( 0 ) to Exit ");
            System.out.println("Are you a 'user' or an 'admin'? Enter your role:");
            String role = input.nextLine();
            if (role.equals("user")){
                userMenu();
            }
            else if (role.equals("admin")){
                adminMenu();
            }
            else if (role.equals("0")){
                System.exit(0);
            }
            else {
                System.out.println("Invalid input, please try again");
            }

        }
    }

    public void userMenu(){
        boolean flag = true;
        while (flag){
            System.out.println("--- User Menu ---");
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
    public void adminMenu(){

        boolean flag = true;
        while (flag){
            System.out.println("--- Admin Menu ---");
            System.out.println("1. Update shipment Status ");
            System.out.println("2. See All shipments");
            System.out.println("3. Return to Main Menu");

            System.out.println("Enter your choice");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice){
                case 1:{
                    view2.updateShipmentStatus(shipmentManager);
                    break;
                }
                case 2:{
                    view1.showAllShipments(shipmentManager);
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
            System.out.println("Want to see the Admin menu again? (Y/N)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("N")){
                flag = false;
            }
        }
    }

}
