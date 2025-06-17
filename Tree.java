import java.util.Scanner;

public class Tree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        tree.populate(sc);
        tree.display();
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        sc.close();
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner sc) {
        System.out.println("Enter the value of the root node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
        System.out.println("Your tree is complete!");
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to insert a node left to the current node ? - "  +  node.value);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the new node which is left of the current node with value "
                    + node.value + ": ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to insert a node right to the current node ? - "  +  node.value);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the new node which is right of the current node with value "
                    + node.value + ": ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    // Terminal-friendly tree display methods
    public void display() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("\n*** Binary Tree Structure ***");
        System.out.println("=============================");
        displayPretty(root, "", true);
        System.out.println("=============================\n");
    }

    private void displayPretty(Node node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }

        // Display current node with ASCII characters
        System.out.println(prefix + (isLast ? "+-- " : "+-- ") + "[" + node.value + "]");

        // Count children to determine formatting
        boolean hasLeft = node.left != null;
        boolean hasRight = node.right != null;

        // Display children
        if (hasLeft || hasRight) {
            if (hasLeft) {
                displayPretty(node.left, prefix + (isLast ? "    " : "|   "), !hasRight);
            }
            if (hasRight) {
                displayPretty(node.right, prefix + (isLast ? "    " : "|   "), true);
            }
        }
    }

    // Alternative ASCII tree display
    public void displayASCII() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("\n--- ASCII Tree Visualization ---");
        displayASCIIHelper(root, 0);
        System.out.println("--------------------------------\n");
    }

    private void displayASCIIHelper(Node node, int level) {
        if (node == null) {
            return;
        }

        // Display right subtree first (top to bottom)
        displayASCIIHelper(node.right, level + 1);

        // Print current node with proper indentation
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println("(" + node.value + ")");

        // Display left subtree
        displayASCIIHelper(node.left, level + 1);
    }

    // Alternative compact display
    public void displayCompact() {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        System.out.println("\n*** Tree Traversals ***");
        System.out.print("In-order:   ");
        inOrder(root);
        System.out.print("\nPre-order:  ");
        preOrder(root);
        System.out.print("\nPost-order: ");
        postOrder(root);
        System.out.println("\n");
    }

    public void preOrder() {
        System.out.println("The preOrder is: ");
        preOrder(root);
        System.out.println(); // Add newline after traversal
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.println("The inOrder is: ");
        inOrder(root);
        System.out.println(); // Add newline after traversal
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        System.out.println("The postOrder is: ");
        postOrder(root);
        System.out.println(); // Add newline after traversal
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

}