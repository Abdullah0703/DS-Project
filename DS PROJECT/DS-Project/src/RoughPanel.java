import java.util.Scanner;

class Welcome {
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RESET = "\u001B[0m";

    void welcome() {
        System.out.println(TEXT_PURPLE + "*************************************************************************************************************************\n");
        System.out.println("<\t\t\t\t***** Welcome to Restaurant Management System *****\t\t\t\t\t>\n");
        System.out.println(TEXT_PURPLE + "*************************************************************************************************************************\n");
        System.out.println("\t\t\t\t\tEnter your username and password to login\n");
    }
}

class User_Authentication {
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";

    public void Access() throws Exception {
        String username, password;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = s.nextLine();
        System.out.print("Enter password: ");
        password = s.nextLine();
        System.out.printf("Verifying");
        int icounter = 3;
        while (icounter != 0) {
            System.out.printf(".");
            icounter--;
            Thread.sleep(500);
        }

        System.out.println("");
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

            System.out.println(TEXT_GREEN + "////////////////////////////////////////////////////////////////////");
            System.out.println(TEXT_GREEN + "\t\t\tAuthentication Successful");
            System.out.println(TEXT_GREEN + "////////////////////////////////////////////////////////////////////" + TEXT_RESET);
            HOME h = new HOME();
            h.home();
        } else {
            System.out.println(TEXT_RED + "////////////////////////////////////////////////////////////////////");
            System.out.println(TEXT_RED + "\t\t\tAuthentication Failed");
            System.out.println(TEXT_RED + "////////////////////////////////////////////////////////////////////" + TEXT_PURPLE);
            System.out.println("Try again");
            java.awt.Toolkit.getDefaultToolkit().beep();
            Access();
//            RECURSION HERE BECAUSE ACCESS FUNCTION IS CALLING ITSELF
        }
    }
}

class HOME {
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_RESET = "\u001B[0m";

    void home() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println(TEXT_PURPLE + "**********MAIN PAGE**********" + TEXT_RESET);
        System.out.println("Please Choose the panel");
        System.out.println("1:Inventory Panel \n2:Customer Panel \n3:Booking Panel \n4:LogOff \n5:exit ");
        System.out.printf("Your choice : ");
        int choice = sc.nextInt();
        do {
            switch (choice) {
                case 1 -> {
                    InventoryMain i = new InventoryMain();
                    i.InverntoryPanel();
                }
                case 2 -> {
                    Customer c = new Customer();
                    c.CustomerPanel();
                }
                case 3 -> {
                    Booking b = new Booking();
                    b.BookingPanel();
                }
                case 4 -> {
                    User_Authentication u = new User_Authentication();
                    u.Access();
                }
                case 5 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Incorrect choice!!!\nReturning Back to Home Page");
                    HOME h = new HOME();
                    h.home();
//                  RECURSION HERE BECAUSE HOME IS CALLING ITSELF
                }
            }
            System.out.println("\nPress Y or y to continue");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
    }
}

public class RoughPanel {
    public static void main(String[] args) throws Exception {
        Welcome w = new Welcome();
        w.welcome();
        User_Authentication s = new User_Authentication();
        s.Access();
    }
}