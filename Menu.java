import java.util.Scanner;

class MenuNode {
    String name;
    Integer price, id;
    MenuNode left, right;

    public MenuNode(String name, Integer price, Integer id) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

class MenuBST {
    MenuNode root;

    MenuNode insert(MenuNode root, String name, Integer price, Integer id) {
        if (root == null) {
            root = new MenuNode(name, price, id);
            return root;
        }
        if (id < root.id) {
            root.left = insert(root.left, name, price, id);
        } else if (id > root.id) {
            root.right = insert(root.right, name, price, id);
        }
        return root;
    }

    // recursively traverse the BST
    void Inorder(MenuNode root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print("\n" + root.id + "\t" + root.name + "\t\t" + root.price + "\t");
            Inorder(root.right);
        }
    }

    //   Search Using Binary-Search Algorithm
    int binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
//            find the middle element
//            int mid = (start + end) / 2 might be possible that (start + end) exceeds the range of int in java
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {/*If target is smaller ignore right half*/
                end = mid - 1;
            } else if (target > arr[mid]) {/*If target is greater ignore left half*/
                start = mid + 1;
            }
        }
        return -1;
    }
}

public class Menu {
    void menu() {
        MenuBST m = new MenuBST();
        String[] strings = {"Coffee", "Biryani", "Pizza", "Noodles", "Soup", "Cold Drink"};
        int[] price = {70, 150, 600, 120, 100, 50};
        int[] id = {1, 2, 3, 4, 5, 6};
        char choice;
        MenuNode root = null;
        for (int i = 0; i < strings.length; i++) {
            root = m.insert(root, strings[i], price[i], id[i]);

        }
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=====MENU=====");
            System.out.println("ID\t\tNAME\t\tPRICE");
            m.Inorder(root);
            System.out.println("\n1-To order");
            System.out.println("2-Search Menu using ID");
            System.out.println("3-Exit");
            int ch = sc.nextInt();
            switch (ch) {

                case 1:
                    System.out.println("\nEnter the Menu Id to select");
                    int menuselect = sc.nextInt();
                    if (menuselect > id.length) {
                        System.out.println("Invalid ID returning to menu");
                        menu();
                    }
                    System.out.println("ID: " + id[menuselect] + " Name:" + strings[menuselect] + " Price:" + price[menuselect]);
                    System.out.println("Enter the quantity");
                    int q = sc.nextInt();
                    int total = price[menuselect] * q;
                    System.out.println("Your total bill is: " + total);
                    break;

                case 2:
                    System.out.println("Enter the Menu ID");
                    int target = sc.nextInt();
                    if (target > id.length || target < 0) {
                        System.out.println("Invalid ID returning to menu");
                        menu();
                        break;
                    }
                    if (m.binarysearch(id, target) != -1) {
                        System.out.println("\nThe product is: " + strings[target] + " The id is: " + id[target] +
                                " The price is: " + price[target]);
                    } else {
                        System.out.println("\nNot found");
                    }
                    break;

                default:
                    System.out.println("Incorrect Choice!");
                    break;
            }
            System.out.println("\nPress Y or y to continue");
            choice = sc.next().charAt(0);
        }
        while (choice == 'Y' || choice == 'y');
    }
}




