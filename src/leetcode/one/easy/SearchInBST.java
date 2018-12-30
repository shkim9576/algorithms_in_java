package leetcode.one.easy;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBST {

    public static void main(String[] args) {
        SearchInBST o = new SearchInBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode result = o.searchBST(root, 2);
        o.dfs(result);
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.println(root.val);
            dfs(root.right);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        return (root.val > val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
