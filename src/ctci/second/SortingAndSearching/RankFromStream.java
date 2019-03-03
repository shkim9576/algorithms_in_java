package ctci.second.SortingAndSearching;

public class RankFromStream {

    public static void main(String[] args) {
        RankFromStream o = new RankFromStream();
        TreeNode root = null;

        root = o.track(root, 5);
        o.track(root, 1);
        o.track(root, 4);
        o.track(root, 4);
        o.track(root, 5);
        o.track(root, 9);
        o.track(root, 7);
        o.track(root, 13);
        o.track(root, 3);
        System.out.println(o.getRankOfNumber(root, 1)); //0
        System.out.println(o.getRankOfNumber(root, 3)); //1
        System.out.println(o.getRankOfNumber(root, 7)); //3
    }

    private TreeNode track(TreeNode root, int n) {
        if (root == null) {
            root = new TreeNode(n);
        } else {
            root = insert(root, n);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int n) {
        if (root == null) return new TreeNode(n);

        if (root.val > n) {
            root.left = insert(root.left, n);
            root.leftSize++;
        } else {
            root.right = insert(root.right, n);
        }

        return root;
    }

    private int getRankOfNumber(TreeNode root, int n) {
        if (root == null) return -1;
        if (root.val == n) return root.leftSize;
        else if (root.val > n) return getRankOfNumber(root.left, n);
        return root.leftSize + 1 + getRankOfNumber(root.right, n);
    }

    static class TreeNode {
        int val;
        int leftSize;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
