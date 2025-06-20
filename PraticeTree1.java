import java.util.Scanner;

public class PraticeTree1 {
    public class Node {
        int value, height;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    public int height(Node node) {
        return node == null ? 0 : node.height;
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values for BST (enter -1 to stop): ");
        while (true) {
            System.out.print("Enter value: ");
            int val = sc.nextInt();
            if (val == -1)
                break;
            root = insert(root, val);
        }
        sc.close();
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.value) {
            node.left = insert(node.left, val);
        } else if (val > node.value) {
            node.right = insert(node.right, val);
        } else {
            System.out.println("Duplicate value " + val + " ignored.");
            return node;
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void display() {
        System.out.println("In-order traversal of BST:");
        displayInOrder(root);
        System.out.println();
    }

    private void displayInOrder(Node node) {
        if (node == null)
            return;
        displayInOrder(node.left);
        System.out.print(node.value + " ");
        displayInOrder(node.right);
    }

    public static void main(String[] args) {
        PraticeTree1 tree = new PraticeTree1();
        tree.insert();
        tree.display();
    }
}