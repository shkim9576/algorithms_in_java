package ctci.second.TreeAndGraph;

public class CheckSubtree {

    public static void main(String[] args) {
        CheckSubtree o = new CheckSubtree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        //         n1
        //        /   \
        //       n2    n3
        //      /  \   / \
        //     n4  n5 n6 n9
        //        /  \
        //       n7  n8
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n5.right = n8;
        n3.right = n9;

        System.out.println(o.isSubtree(n1, n3));

        TreeNode n10 = new TreeNode(3);
        TreeNode n11 = new TreeNode(6);
        n10.left = n11;

        System.out.println(o.isSubtree(n1, n10));
    }

    private boolean isSubtree(TreeNode n1, TreeNode n2) {
        if (n2 == null) return true;
        TreeNode n = findNode(n1, n2);
        return isSameTree(n, n2);
    }

    private TreeNode findNode(TreeNode root, TreeNode target) {
        if (root == null || target == null) return null;
        if (root.val == target.val) return root;
        TreeNode l = findNode(root.left, target);
        if (l != null) return l;
        return findNode(root.right, target);
    }

    private boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return n1.val == n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
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
