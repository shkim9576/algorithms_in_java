package leetcode.one.easy;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree o = new SymmetricTree();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(4);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);

        TreeNode n2 = new TreeNode(1);
        n2.left = new TreeNode(2);
        n2.right = new TreeNode(2);
        n2.left.left = new TreeNode(3);
        n2.left.right = new TreeNode(4);
        n2.right.left = new TreeNode(3);
        n2.right.right = new TreeNode(4);

        System.out.println(o.isSymmetric(n1)); //true
        System.out.println(o.isSymmetric(n2)); //false
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricRec(root.left, root.right);
    }

    boolean isSymmetricRec(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        return l.val == r.val && isSymmetricRec(l.right, r.left) && isSymmetricRec(l.left, r.right);
    }
}
