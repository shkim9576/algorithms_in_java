package ctci.second.TreeAndGraph;

public class CheckBalanced {

    public static void main(String[] args) {
        CheckBalanced o = new CheckBalanced();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(o.isBalanced(n1));

        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.right = n5;
        System.out.println(o.isBalanced(n1));
    }

    boolean isBalanced(TreeNode root) {
        return rec(root) == -1 ? false : true;
    }

    int rec(TreeNode root) {
        if (root == null) return 0;

        int l = rec(root.left);
        if (l == -1) return -1;
        int r = rec(root.right);
        if (r == -1) return -1;

        if (Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
