import java.util.EmptyStackException;
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


    class AuthenticationNode {
        String str;
        AuthenticationNode next;
    }

    class Stack {
        AuthenticationNode top;
        int length;

        Stack() {
            top = null;
            length = 0;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(String name) {
            AuthenticationNode temp = new AuthenticationNode();
            temp.str = name;
            if (temp == null) {
                System.out.println("Stack overflow");
            }
            temp.next = top;
            top = temp;
        }

        public String popname() {
            if (!isEmpty()) {
                String a = top.str;
                top = top.next;
                return a;
            } else {
                System.out.println("Stack is Empty");
                return null;
            }
        }

        public String peekname() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return top.str;
        }
    }

    public void Access() throws Exception {
        String username, password;
        Stack stackUsername = new Stack();
        Stack stackPassword = new Stack();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = s.nextLine();
        stackUsername.push("admin");
        System.out.print("Enter password: ");
        password = s.nextLine();
        stackPassword.push("admin");
        System.out.printf("Verifying");
        int icounter = 3;
        while (icounter != 0) {
            System.out.printf(".");
            icounter--;
            Thread.sleep(500);
        }

        System.out.println("");
        if (username.equals(stackUsername.peekname()) && password.equals(stackPassword.peekname())) {
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
        System.out.println("1:Inventory Panel \n2:Customer Panel \n3:Booking Panel \n4:LogOff \n5:exit \n6-Menu");
        System.out.printf("Your choice : ");
        int choice = sc.nextInt();
        do {
            switch (choice) {
                case 1 -> {
                    InventoryRough i = new InventoryRough();
                    i.inventoryroughpanel();
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

                case 6 -> {
                    Menu m = new Menu();
                    m.menu();
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
        User_Authentication us = new User_Authentication();
        us.Access();
    }
}