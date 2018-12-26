package leetcode.one.easy;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/submissions/
public class MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST o = new MinimumAbsoluteDifferenceInBST();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        System.out.println(o.getMinimumDifference(root)); //1
    }

    Integer prev = null;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return result;

        getMinimumDifference(root.left);
        if (prev != null) result = Math.min(result, Math.abs(root.val - prev));
        prev = root.val;
        getMinimumDifference(root.right);

        return result;
    }
}
