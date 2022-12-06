import java.util.Scanner;

class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets; // capacity
    private int size; // number of qty name pairs in hash table or number of hash nodes in a HashTable

    public HashTable() {
        this(10);
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

    private int getBucketIndex(Integer key) {
        return key % numOfBuckets; // buckets.length
    }

    //==============INSERTION IN THE HASHTABLE==========================================================================
    public void put(String name, Integer qty, Integer id) {
        if (name == null || qty == null || id == null) {
            throw new IllegalArgumentException("Qty or Name or Id is null !!!");
        }
        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(id)) {
                head.name = name;
                return;
            }
            head = head.next;

        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(name, qty, id);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    //=====================REMOVING FROM THE HASHTABLE==================================================================
    public String remove(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }

        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex]; // (21, "Tom") -> (31, "Harry") -> (41, "Sana") -> null
        HashNode previous = null;

        while (head != null) {
            if (head.id.equals(id)) {
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

    //============================GET THE NAME OF THE PRODUCT===========================================================
    public String getName(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(id)) {
                return head.name;
            }
            head = head.next;
        }
        return null;
    }

    //    ========================GET THE QTY OF THE PRODUCT============================================================
    public Integer getQty(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(id)) {
                return head.qty;
            }
            head = head.next;
        }
        return null;
    }

    //    ========================GET THE ID OF THE PRODUCT==========================
    public Integer getID(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID is null !!!");
        }
        int bucketIndex = getBucketIndex(id);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.id.equals(id)) {
                return head.id;
            }
            head = head.next;
        }
        return null;
    }
}

public class InventoryMain {
    public static void main(String[] args) {
        HashTable h = new HashTable();
        Scanner sc = new Scanner(System.in);
        char choice;
        do {
            System.out.println("Select an Operation");
            System.out.println("1- Add an Item");
            System.out.println("2-Remove an Item");
            System.out.println("3-Print Details");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("=====ENTER THE DETAILS=====");
                    System.out.println("Enter the name of your item:");
                    String name = sc.next();
                    System.out.println("Enter the quantity of the product");
                    int qty = sc.nextInt();
                    System.out.println("Enter the ID of the product");
                    int id = sc.nextInt();
                    h.put(name, qty, id);
                    break;

                case 2:
                    System.out.println("=====DELETE ITEM=====");
                    System.out.println("Enter the ID of the product");
                    int id2 = sc.nextInt();
                    System.out.println("The Item: " + h.remove(id2) + " is removed");
                    break;

                case 3:
                    System.out.println("=====PRINT THE PRODUCT=====");
                    System.out.println("Enter the Id of the product you want to see");
                    int id3 = sc.nextInt();
                    System.out.println("The product is: " + h.getName(id3) + " and the ID is: " + h.getID(id3) +
                            " and the quantity is: " + h.getQty(id3));
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
