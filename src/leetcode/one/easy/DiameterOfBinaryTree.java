package leetcode.one.easy;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree o = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(o.diameterOfBinaryTree(root)); //3
    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max;
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
