package leetcode.one.easy;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        MaxDepthOfBinaryTree o = new MaxDepthOfBinaryTree();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(4);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);
        n1.right.right.right = new TreeNode(5);

        System.out.println(o.maxDepth(n1)); // 4
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
