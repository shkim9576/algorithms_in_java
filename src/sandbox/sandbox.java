package sandbox;


import java.util.*;

public class sandbox {

    public static void main(String[] args) {
        sandbox o = new sandbox();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(o.sumNumbers(root));
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(path);
            sum += Integer.valueOf(path);
            return;
        }

        path += root.val;

        dfs(root.left, path);
        dfs(root.right, path);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
