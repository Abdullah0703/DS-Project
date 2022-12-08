import java.util.ArrayList;
import java.util.Scanner;

class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets; // capacity
    private int size; // number of price name pairs in hash table or number of hash nodes in a HashTable2

    public HashTable() {
        this(100); // default capacity
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    private class HashNode {
        private Integer qty, id;
        private String name;
        private HashNode next; // reference to next HashNode

        public HashNode(String name, Integer qty, int id) {
            this.name = name;
            this.qty = qty;
            this.id = id;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(String name, Integer qty, Integer id) {
        if (id == null || name == null || id == null) {
            throw new IllegalArgumentException("Qty or Name or Id is null !!!");
        }
        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.qty.equals(id)) {
                head.name = name;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(name, qty, id); // (price, name) -> null
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketIndex(Integer key) {
        return key % numOfBuckets; // buckets.length
    }

    //==================GET NAME OF THE PRODUCT=========================================================================
    public String getname(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(key)) {
                return head.name;
            }
            head = head.next;
        }
        return null;
    }

    //==============GET THE ID OF THE PRODUCT=====================================================================
    public Integer getID(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(key)) {
                return head.id;
            }
            head = head.next;
        }
        return null;
    }

    //==================GET THE QUANTITY OF THE PRODUCT============================================
    public Integer getQty(Integer qty) {
        if (qty == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(qty);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.qty.equals(qty)) {
                return head.qty;
            }
            head = head.next;
        }
        return null;
    }

    //===========================ADJUST QTY==============================
    public Integer AdjQty(Integer qty, int qty2) {
        if (qty == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(qty);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.qty.equals(qty)) {
                if (qty2 < 0) {
                    System.out.println("The quantity that is to be subtracted is < 0");
                    return head.qty;
                }
                head.qty = head.qty - qty2;

                return head.qty;
            }
            head = head.next;
        }
        return null;
    }

    //    ===================================REMOVE FUNC==================
    public String remove(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex]; // (21, "Tom") -> (31, "Harry") -> (41, "Sana") -> null
        HashNode previous = null;

        while (head != null) {
            if (head.qty.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.name;
    }
}

public class Inventory {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";

    public void InventoryPanel() throws Exception {

        HashTable h = new HashTable();
        Scanner sc = new Scanner(System.in);
        char choice;
        do {
            System.out.println(TEXT_PURPLE + "\t/*=====INVENTORY PANEL=====*/" + TEXT_RESET);
            System.out.println("Select an Operation");
            System.out.println("1- Add an Item");
            System.out.println("2-Remove an Item");
            System.out.println("3-Print Details");
            System.out.println("4-Goto Main Page");
//            System.out.println("4- Adjust the quantity");
//            ArrayList<String> strings = new ArrayList<>();
//            String[] st = {"Coffee", "Biryani", "Pizza", "Noodles", "Soup", "Cold Drink"};
//            for (int i = 0; i < st.length; i++) {
//                strings.add(st[i]);
//            }
//            int[] q = {100, 100, 100, 100, 100, 100};
//            ArrayList<Integer> qty = new ArrayList<>();
//            for (int i = 0; i < q.length; i++) {
//                qty.add(q[i]);
//            }
//            int[] is = {1, 2, 3, 4, 5, 6};
//            ArrayList<Integer> id = new ArrayList<>();
//            for (int i = 0; i < is.length; i++) {
//                id.add(is[i]);
//            }
//
//            for (int i = 0; i < is.length; i++) {
//                h.put(strings.get(i), qty.get(i), id.get(i));
//            }

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("=====ENTER THE DETAILS=====");
                    System.out.println("Enter the name of your item:");
                    String name = sc.next();
//                    strings.add(name);
                    System.out.println("Enter the quantity of the product");
                    int qty2 = sc.nextInt();
//                    qty.add(qty2);
                    System.out.println("Enter the ID of the product");
                    int id2 = sc.nextInt();
//                    id.add(id2);
                    h.put(name, qty2, id2);
                    break;

                case 2:
                    System.out.println("=====DELETE ITEM=====");
                    System.out.println("Enter the ID of the product");
                    int id3 = sc.nextInt();
//                    if (id3 > id.size() || id3 < 0) {
//                        System.out.println("Wrong ID returning to Inventory Menu");
//                        InventoryPanel();
//                    }
                    System.out.println("The Item: " + h.remove(id3) + " is removed");
                    break;

                case 3:
                    System.out.println("=====PRINT THE PRODUCT=====");
                    System.out.println("Enter the Id of the product you want to see");
                    int id4 = sc.nextInt();
                    System.out.println("The product is: " + h.getname(id4) + " and the ID is: " + h.getID(id4));
                    break;

                case 4:
                    Home h1 = new Home();
                    h1.home();
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
