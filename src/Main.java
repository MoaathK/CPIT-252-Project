import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Test Number 1");
        boolean check = true;
        Scanner input = new Scanner(System.in);
        while (check){
            System.out.print("welcome to the Transport Management System (TMS)\n" +
                                "Are you a 'user' or an 'admin'? Enter your role:");
            String name = input.nextLine();
            if (name.equalsIgnoreCase("user")){

            }
            else if (name.equalsIgnoreCase("admin")){

            }

        }
        
    }
}
