import java.util.Scanner;

public class Customer {
    /*BECAUSE CUSTOMER COMES AND GO IN A FIFO(FIRST-IN-FIRST-OUT) MANNER THAT'S WHY USED QUEUE IN LL HERE*/

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";

    class CustomerNode {
        String name;
        int id;
        CustomerNode next;

        public CustomerNode(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    CustomerNode front, rear;
    int length;

    public Customer() {
        this.front = front;
        this.rear = rear;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(String name, int id) {
        CustomerNode temp = new CustomerNode(name, id);
        // If queue is empty, then new node is front and rear both
        if (rear == null) {
            front = rear = temp;
            return;
        }
        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
        length++;
    }

    // Store previous front and move front one node ahead
    public void dequeue() {
        if (front == null) {
            System.out.println("There are no customers to be removed ");
            return;
        }
        CustomerNode temp = front;
        front = front.next;
        // If front becomes NULL, then change rear also as NULL
        if (front == null) {
            rear = null;
        }
    }

    public void Print() {
        if (isEmpty()) {
            System.out.println("There are no Customers in the Restaurant");
            return;
        }
        CustomerNode temp = front;
        System.out.println("Name\t\tID");
        while (temp.next != null) {  //Changed temp into temp.next
            System.out.print(temp.id + "\t\t" + temp.name);
            temp = temp.next;
            System.out.println();
        }
        System.out.println();
    }

    public void CustomerPanel() throws Exception {
        Customer c = new Customer();
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println(TEXT_PURPLE + "\t/*=====CUSTOMER PANEL=====*/" + TEXT_RESET);
            System.out.println("Select an Operation");
            System.out.println("1- Add a Customer");
            System.out.println("2-Remove a Customer");
            System.out.println("3-Print Customer Details");
            System.out.println("4-Go back to Main Page");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the name of the customer");
                    String name = sc.next();
                    System.out.println("Enter the ID of Customer");
                    int id = sc.nextInt();
                    c.enqueue(name, id);
                    break;

                case 2:
                    System.out.println("Customer Removed");
                    c.dequeue();
                    break;

                case 3:
                    System.out.println("Following are the customer Details");
                    c.Print();
                    break;

                case 4:
                    Home h = new Home();
                    h.home();
                    break;

                default:
                    System.out.println("Incorrect Choice!");
                    break;
            }
            System.out.println("\nPress Y or y to continue");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');
    }
}
