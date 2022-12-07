import java.util.Scanner;

class MenuNode {
    String name;
    Integer qty, id;
    MenuNode left, right;

    public MenuNode(String name, Integer qty, Integer id) {
        this.name = name;
        this.qty = qty;
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

class MenuBST {
    MenuNode root;

    MenuNode insert(MenuNode root, String name, Integer qty, Integer id) {
        if (root == null) {
            root = new MenuNode(name, qty, id);
            return root;
        }
        if (id < root.id) {
            root.left = insert(root.left, name, qty, id);
        } else if (id > root.id) {
            root.right = insert(root.right, name, qty, id);
        }
        return root;
    }

    // recursively traverse the BST
    void Inorder(MenuNode root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print("\n" + root.id + "\t" + root.name + "\t" + root.qty + "\t");
            Inorder(root.right);
        }
    }

//   Search Using Binary-Search Algorithm



}

public class Menu {
    public static void main(String[] args) {
        MenuBST m = new MenuBST();
        String[] strings = {"Coffee", "Biryani", "Pizza", "Noodles", "Soup", "Cold Drink"};
        int[] qty = {10, 10, 10, 10, 10, 10};
        int[] id = {1, 2, 3, 4, 5, 6};
        MenuNode root = null;
        for (int i = 0; i < strings.length; i++) {
            root = m.insert(root, strings[i], qty[i], id[i]);

        }
        m.Inorder(root);
        Scanner sc = new Scanner(System.in);


    }
}

