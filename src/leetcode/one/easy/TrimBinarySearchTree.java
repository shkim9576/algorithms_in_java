package leetcode.one.easy;

//https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBinarySearchTree {

    public static void main(String[] args) {
        TrimBinarySearchTree o = new TrimBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        TreeNode result = o.trimBST(root, 1, 2);
        o.dfs(result);
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.println(root.val);
            dfs(root.right);
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
