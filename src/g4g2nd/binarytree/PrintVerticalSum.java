package g4g2nd.binarytree;

import java.util.TreeMap;

public class PrintVerticalSum {

    public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left =new TreeNode(6);
        root.right.right =new TreeNode(7);
        PrintVerticalSum t = new PrintVerticalSum();

        // 4, 2, 12, 3 and 7
        System.out.println("Following are the values of" +
                           " vertical sums with the positions" +
                           " of the columns with respect to root ");
        t.VerticalSumMain(root);
    }

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode (int d) {
            data = d;
        }
    }

    void VerticalSumMain(TreeNode root) {
        if (root == null) return;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        helper(root, map, 0);

        for (int i : map.values()) {
            System.out.print(i + " ");
        }
    }

    void helper(TreeNode root, TreeMap<Integer, Integer> map, int level) {
        if (root == null) return;

        int sum = map.getOrDefault(level, 0);
        sum += root.data;
        map.put(level, sum);

        helper(root.left, map, level-1);
        helper(root.right, map, level+1);
    }
}
