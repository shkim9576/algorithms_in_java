package leetcode.one.easy;

//https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        SumOfLeftLeaves o = new SumOfLeftLeaves();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(o.sumOfLeftLeaves(root)); //24
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return helper(root.left, true) + helper(root.right, false);
    }

    public int helper(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && isLeft) return node.val;

        return helper(node.left, true) + helper(node.right, false);
    }
}
