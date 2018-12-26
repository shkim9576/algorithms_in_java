package leetcode.one.easy;

//https://leetcode.com/problems/convert-bst-to-greater-tree/
public class ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        ConvertBSTToGreaterTree o = new ConvertBSTToGreaterTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode node = o.convertBST(root);
        o.dfs(node);
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.println(root.val);
            dfs(root.right);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);
        return root;
    }

    public int convert(TreeNode root, int sum) {
        if (root == null) return sum;
        root.val += convert(root.right, sum);
        return convert(root.left, root.val);
    }
}
