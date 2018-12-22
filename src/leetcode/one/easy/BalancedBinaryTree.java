package leetcode.one.easy;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree o = new BalancedBinaryTree();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(4);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);
        n1.right.right.right = new TreeNode(5);

        System.out.println(o.isBalanced(n1)); // true
    }

    // bottom up O(n)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // top down approach O(N^2)
    public boolean isBalancedTopDown(TreeNode root) {
        if (root == null) return true;

        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);

        return Math.abs(leftMax - rightMax) <= 1 && isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    public int getMax(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getMax(node.left), getMax(node.right)) + 1;
    }

}
