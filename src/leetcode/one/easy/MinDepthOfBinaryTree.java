package leetcode.one.easy;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        MinDepthOfBinaryTree o = new MinDepthOfBinaryTree();
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);
        n1.right.right.right = new TreeNode(5);

        System.out.println(o.minDepth(n1)); //2
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        if (leftMin == 0) return rightMin + 1;
        if (rightMin == 0) return leftMin + 1;

        return Math.min(leftMin, rightMin) + 1;
    }
}
