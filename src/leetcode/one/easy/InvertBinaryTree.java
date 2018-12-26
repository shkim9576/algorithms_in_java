package leetcode.one.easy;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree o = new InvertBinaryTree();
        TreeNode inverted = o.invertTree(root);

        o.dfs(inverted); // 9 7 6 4 3 2 1
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.print(root.val + " ");
            dfs(root.right);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }
}
