package leetcode.one.easy;

//https://leetcode.com/problems/longest-univalue-path/
public class LongestUnivaluePath {

    public static void main(String[] args) {
        LongestUnivaluePath o = new LongestUnivaluePath();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(o.longestUnivaluePath(root)); //2
    }

    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root, -1);
        return result;
    }

    public int helper(TreeNode root, int p) {
        if (root == null) return 0;

        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);

        int count = 0;
        result = Math.max(result, left + right);
        if (root.val == p) count = 1 + Math.max(left, right);

        return count;
    }
}
