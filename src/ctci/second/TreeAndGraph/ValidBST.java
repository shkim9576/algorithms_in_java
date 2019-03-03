package ctci.second.TreeAndGraph;

public class ValidBST {

    public static void main(String[] args) {
        ValidBST o = new ValidBST();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n3.left = n1;
        n1.right = n2;
        n3.right = n4;
        n4.right = n5;
        n5.right = n6;
        System.out.println(o.isBST(n3));

        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n3.left = n1;
        n1.left = n2;
        n3.right = n5;
        n5.left = n4;
        System.out.println(o.isBST(n3));

        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n6 = new TreeNode(6);
        n3.left = n1;
        n1.right = n2;
        n3.right = n4;
        n4.right = n5;
        n5.right = n6;
        System.out.println(o.isBSTInorder(n3));

        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n3.left = n1;
        n1.left = n2;
        n3.right = n5;
        n5.left = n4;
        System.out.println(o.isBSTInorder(n3));
    }

    TreeNode prev = null;

    private boolean isBSTInorder(TreeNode root) {
        if (root != null) {
            isBSTInorder(root.left);
            if (prev != null && prev.val > root.val) return false;
            prev = root;
            isBSTInorder(root.right);
        }
        return true;
    }

    private boolean isBST(TreeNode root) {
        return rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean rec(TreeNode root, int min, int max) {
        if (root == null) return true;
        return root.val < max &&
                root.val > min &&
                rec(root.left, min, root.val) &&
                rec(root.right, root.val, max);
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
