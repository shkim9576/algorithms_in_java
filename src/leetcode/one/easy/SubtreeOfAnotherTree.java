package leetcode.one.easy;

//https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        SubtreeOfAnotherTree o = new SubtreeOfAnotherTree();

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(o.isSubtree(s, t)); //true
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        return (s.val == t.val) && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
