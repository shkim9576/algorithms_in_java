package ctci.second.TreeAndGraph;

public class FirstCommonAncestor {

    public static void main(String[] args) {
        FirstCommonAncestor o = new FirstCommonAncestor();

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
        //      /  \   /
        //     n4  n5 n6
        //        /  \
        //       n7  n8
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n5.right = n8;

        System.out.println(o.nodeExist(n1, n4));
        System.out.println(o.nodeExist(n1, n8));
        System.out.println(o.nodeExist(n1, n9));

        System.out.println(o.lca(n1, n4, n8).val); //n2
        System.out.println(o.lca(n1, n4, n6).val); //n1
        System.out.println(o.lca(n1, n2, n8).val); //n2
        System.out.println(o.lca(n1, n6, n3).val); //n3
    }

    private boolean nodeExist(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return nodeExist(root.left, target) || nodeExist(root.right, target);
    }

    private TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return null;
        if (root.val == n1.val || root.val == n2.val) return root;

        TreeNode l = lca(root.left, n1, n2);
        TreeNode r = lca(root.right, n1, n2);

        if (l != null && r != null) return root;
        return l == null ? r : l;
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
