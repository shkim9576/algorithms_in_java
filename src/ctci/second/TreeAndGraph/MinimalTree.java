package ctci.second.TreeAndGraph;

public class MinimalTree {
    public static void main(String[] args) {
        MinimalTree o = new MinimalTree();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = o.buildMinBST(A, 0, A.length - 1);
        o.inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    private TreeNode buildMinBST(int[] A, int l, int r) {
        if (l > r) return null;

        int mi = l + (r - l) / 2;
        TreeNode root = new TreeNode(A[mi]);
        root.left = buildMinBST(A, l, mi - 1);
        root.right = buildMinBST(A, mi + 1, r);
        return root;
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
