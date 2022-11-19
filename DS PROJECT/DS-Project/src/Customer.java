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
            System.out.println("The restaurant is Empty");
            return;
        }
        CustomerNode temp = front;
        System.out.println("Name\tID\t\tBill");
        while (temp != null) {
            System.out.print(temp.name +"\t\t"+ temp.id+"\t\t"+temp.bill);
            temp = temp.next;
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the name of the customer");
            String name = sc.next();
            System.out.println("Enter the ID of Bill");
            String id = sc.next();
            System.out.println("Enter the Amount/bill");
            float bill = sc.nextFloat();
            c.enqueue(name, id, bill);
        }
        c.Print();
        c.dequeue();
        c.Print();
    }
}

