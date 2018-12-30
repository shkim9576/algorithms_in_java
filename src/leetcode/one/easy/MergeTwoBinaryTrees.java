package leetcode.one.easy;

// https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        MergeTwoBinaryTrees o = new MergeTwoBinaryTrees();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        TreeNode merged = o.mergeTrees(t1, t2);
        o.dfs(merged);
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            System.out.println(root.val);
            dfs(root.right);
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
