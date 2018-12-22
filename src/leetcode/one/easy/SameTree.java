package leetcode.one.easy;

//https://leetcode.com/problems/same-tree/
public class SameTree {
    public static void main(String[] args) {
        SameTree o = new SameTree();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);

        TreeNode n2 = new TreeNode(1);
        n2.left = new TreeNode(2);
        n2.right = new TreeNode(3);

        TreeNode n3 = new TreeNode(1);
        n3.left = new TreeNode(3);
        n3.right = new TreeNode(2);

        System.out.println(o.isSameTree(n1, n2)); //true
        System.out.println(o.isSameTree(n1, n3)); //false
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
