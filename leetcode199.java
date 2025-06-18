import java.util.ArrayList;
import java.util.List;

public class leetcode199 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode root;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list, int level) {
        if(node == null) return;
        if(level == list.size()){
            list.add(node.val);
        }
        dfs(node.right, list, level + 1);
        dfs(node.left, list, level + 1);
    }

    public TreeNode createSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public static void main(String[] args) {
        leetcode199 solution = new leetcode199();
        TreeNode sampleRoot = solution.createSampleTree();
        
        List<Integer> result = solution.rightSideView(sampleRoot);
        System.out.println("Right side view: " + result);
        // output: [1, 3, 4]
    }
}
