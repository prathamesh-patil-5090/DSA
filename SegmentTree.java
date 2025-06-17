public class SegmentTree {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 6, -2, -8, 4, 9 };
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(0, 2));
        tree.update(0, 10);
        System.out.println(tree.query(0, 2));
        tree.display();
    }

    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: "
                    + node.left.data + " => ";
        } else {
            str += "No Left Child";
        }

        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " => ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: "
                    + node.right.data + " => ";
        } else {
            str += "No Right Child";
        }

        System.out.println(str + '\n');

        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int queryStart, int queryEnd) {
        return this.query(this.root, queryStart, queryEnd);
    }

    private int query(Node node, int queryStart, int queryEnd) {
        if (node.startInterval >= queryStart && node.endInterval <= queryEnd) {
            return node.data;
        } else if (node.startInterval > queryEnd || node.endInterval < queryStart) {
            return 0;
        } else {
            return this.query(node.left, queryStart, queryEnd) + this.query(node.right, queryStart, queryEnd);
        }
    }

    public void update(int index, int value) {
        this.root.data = this.update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
