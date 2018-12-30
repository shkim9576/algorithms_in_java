package leetcode.one.easy;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes o = new MinimumDistanceBetweenBSTNodes();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(o.minDiffInBST(root)); //1
    }

    int result = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != null) result = Math.min(root.val - prev, result);
        prev = root.val;
        dfs(root.right);
    }
}
