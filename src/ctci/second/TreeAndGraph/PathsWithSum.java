package ctci.second.TreeAndGraph;

public class PathsWithSum {

    public static void main(String[] args) {
        PathsWithSum o = new PathsWithSum();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(-2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(10);
        TreeNode n8 = new TreeNode(-3);
        TreeNode n9 = new TreeNode(11);

        //         10
        //        /  \
        //       5    -3
        //      / \     \
        //     3   2     11
        //    / \   \
        //   3  -2   1
        n7.left = n4;
        n7.right = n8;
        n4.left = n1;
        n4.right = n5;
        n1.left = n2;
        n1.right = n3;
        n5.right = n6;
        n8.right = n9;

        System.out.println(o.countPath(n7, 8));
    }

    private int countPath(TreeNode root, int sum) {
        if (root == null) return 0;
        return countPath(root.left, sum) + countPathRec(root, sum, 0) + countPath(root.right, sum);
    }

    private int countPathRec(TreeNode root, int target, int curr) {
        if (root == null) return 0;
        curr += root.val;
        int count = curr == target ? 1 : 0;
        return count + countPathRec(root.left, target, curr) + countPathRec(root.right, target, curr);
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
