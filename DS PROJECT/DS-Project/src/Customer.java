import java.util.Scanner;
public class Customer {
    /*BECAUSE CUSTOMER COMES AND GO IN A FIFO(FIRST-IN-FIRST-OUT) MANNER THAT'S WHY USED QUEUE HERE*/
    class CustomerNode {
        String name, id;
        float bill;
        CustomerNode next;

        public CustomerNode(String name, String id, float bill) {
            this.name = name;
            this.id = id;
            this.bill = bill;
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

    public void enqueue(String name, String id, float bill) {
        CustomerNode temp = new CustomerNode(name, id, bill);
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
        System.out.println("Name\tID\t\tBill");
        while (temp != null) {
            System.out.print(temp.name + "\t\t" + temp.id + "\t\t" + temp.bill);
            temp = temp.next;
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        char choice;
        do {
            System.out.println("Select an Operation");
            System.out.println("1- Add a Customer");
            System.out.println("2-Remove a Customer");
            System.out.println("3-Print Customer Details");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the name of the customer");
                    String name = sc.next();
                    System.out.println("Enter the ID of Bill");
                    String id = sc.next();
                    System.out.println("Enter the Amount/bill");
                    float bill = sc.nextFloat();
                    c.enqueue(name, id, bill);
                    break;

                case 2:
                    System.out.println("Customer Removed");
                    c.dequeue();
                    break;

                case 3:
                    System.out.println("Following are the customer Details");
                    c.Print();
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
