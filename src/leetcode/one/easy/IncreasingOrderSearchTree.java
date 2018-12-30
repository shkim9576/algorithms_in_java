package leetcode.one.easy;

//https://leetcode.com/problems/increasing-order-search-tree/
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        IncreasingOrderSearchTree o = new IncreasingOrderSearchTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode result = o.increasingBST(root);
        o.dfs(result);
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.println(root.val);
            dfs(root.right);
        }
    }

    TreeNode parent = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(-1);
        parent = result;
        inorder(root);
        return result.right;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            parent.right = root;
            parent.left = null;
            parent = root;
            inorder(root.right);
        }
    }
}
