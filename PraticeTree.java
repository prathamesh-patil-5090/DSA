import java.util.Scanner;

public class PraticeTree {
    public class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the value of tree : ");
        int rootValue = sc.nextInt();
        this.root = new Node(rootValue);

        insert(sc, root);
    }

    private void insert(Scanner sc, Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Do you want to insert in the left of the node " + node.value + ": ");
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value of left node to " + node.value + " value node : ");
            node.left = new Node(sc.nextInt());
            insert(sc, node.left);
        }

        System.out.println("Do you want to insert in the right of the node " + node.value + ": ");
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of right node to " + node.value + "value node : ");
            node.right = new Node(sc.nextInt());
            insert(sc, node.right);
        }
    }

    public void display() {
        System.out.print("The Inorder traversal is as follows: ");
        InorderTraversal(this.root);
        System.out.println();
        System.out.print("The Preorder traversal is as follows: ");
        PreorderTraversal(this.root);
        System.out.println();
        System.out.print("The Postorder traversal is as follows: ");
        PostorderTraversal(this.root);
        System.out.println();
    }

    private void InorderTraversal(Node node) {
        if (node == null)
            return;
        InorderTraversal(node.left);
        System.out.print(node.value + " ");
        InorderTraversal(node.right);
    }

    private void PostorderTraversal(Node node) {
        if (node == null)
            return;
        PostorderTraversal(node.left);
        PostorderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    private void PreorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        PreorderTraversal(node.left);
        PreorderTraversal(node.right);
    }

    public static void main(String[] args) {
        PraticeTree tree = new PraticeTree();
        tree.insert();
        tree.display();
    }
}
