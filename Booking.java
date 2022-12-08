import java.util.Scanner;

public class Booking {

    class BookingNode {
        String name, date, time, number;
        int id;
        BookingNode next;

        public BookingNode(String name, String date, String time, String number, int id) {
            this.name = name;
            this.date = date;
            this.time = time;
            this.number = number;
            this.id = id;
            this.next = null;
        }
    }

    int size;
    BookingNode head, tail;

    public Booking() {
        this.size = 0;
    }

    public void insert(String name, String date, String time, String number, int id) {
        BookingNode thenode = new BookingNode(name, date, time, number, id);
        thenode.name = name;
        thenode.number = number;
        thenode.date = date;
        thenode.time = time;
        thenode.id = id;
        if (head == null) {
            head = thenode;
        } else {
            BookingNode temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            temp.next = thenode;
        }
    }

    public int deleteFirst() {
        int val = head.id;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deletePosition(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        BookingNode prev = getnode(index - 1);
        int val = prev.next.id;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        BookingNode secondLastnode = getnode(size - 2);
        int val = tail.id;
        tail = secondLastnode;
        tail.next = null;
        size--;
        return val;
    }

    public BookingNode getnode(int index) {
        BookingNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public BookingNode middleNode(BookingNode start, BookingNode last) {
        if (start == null)
            return null;

        BookingNode slow = start;
        BookingNode fast = start.next;

        while (fast != last) {
            fast = fast.next;
            if (fast != last) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public BookingNode binarySearch(BookingNode head, int id) {
        BookingNode start = head;
        BookingNode last = null;

        do {
            // Find Middle
            BookingNode mid = middleNode(start, last);
            // If middle is empty
            if (mid == null)
                return null;
            // If value is present at middle
            if (mid.id == id)
                return mid;
                // If value is less than mid
            else if (mid.id > id) {
                last = mid;
            }
            // If the value is more than mid.
            else
                start = mid.next;
        } while (last == null || last != start);
        // value not present
        return null;
    }


    public void display() {
        BookingNode temp = head;
        System.out.println("Name\tID\tTime\tDate\tnumber");
        while (temp != null) {
            System.out.print(temp.name + "\t" + temp.id + "\t" + temp.time + "\t" + temp.date + "\t" + temp.number);
            temp = temp.next;
        }
    }

    public void BookingPanel() throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice;
        Booking b = new Booking();
        do {
            System.out.println("Select an Operation");
            System.out.println("1- Add a Booking");
            System.out.println("2-Remove a Booking");
            System.out.println("3-Search Booking Details");
            System.out.println("4-Print Details of Booking");
            System.out.println("5-Go back to Main Page");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter name");
                    String name = sc.next();
                    System.out.println("Enter time in format(12:00/HH:MM)");
                    String time = sc.next();
                    System.out.println("Enter Date in format(DD/MM/YYYY");
                    String date = sc.next();
                    System.out.println("Enter ID");
                    int id = sc.nextInt();
                    System.out.println("Enter Phone Number");
                    String number = sc.next();
                    b.insert(name, date, time, number, id);
                    break;

                case 2:
                    System.out.println("Enter the booking Id you want to delete?");
                    int n = sc.nextInt();
                    if (n == 1) {
                        b.deleteFirst();
                    } else {
                        b.deletePosition(n);
                    }
                    break;

                case 3:
                    System.out.println("Enter the Booking Id you want to search");
                    int idd = sc.nextInt();
                    b.binarySearch(b.head, idd);
                    if (b.binarySearch(b.head, idd) == null) {
                        System.out.println("Not present");
                    } else {
                        System.out.println("Present");
                    }
                case 4:
                    b.display();
                    break;

                case 5:
                    HOME h = new HOME();
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
