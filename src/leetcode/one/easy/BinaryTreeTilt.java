package leetcode.one.easy;

//https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt {

    public static void main(String[] args) {
        BinaryTreeTilt o = new BinaryTreeTilt();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(o.findTilt(root)); //1
    }

    public int findTilt(TreeNode root) {
        int[] ret = new int[1];
        helper(root, ret);
        return ret[0];
    }

    private int helper(TreeNode node, int[] ret) {
        if (node == null) {
            return 0;
        }
        int l = helper(node.left, ret);
        int r = helper(node.right, ret);
        ret[0] += Math.abs(l - r);
        return l + r + node.val;
    }
}
