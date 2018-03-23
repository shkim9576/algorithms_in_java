package g4g.hash.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalSumOfBinaryTree {
    // https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/

    public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        ==> 4, 2, 12(1+5+6), 3, 7
        */
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalSumOfBinaryTree ob = new VerticalSumOfBinaryTree();
        List<Integer> result = ob.verticalLevelSum(root);
        System.out.println(result);
    }

    static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
        }
    }

    List<Integer> verticalLevelSum(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>(); //<vl:sum>
        dfs(root, 0, map);

        for (int sum : map.values()) { // ordered by vl <vl:sum>
            result.add(sum);
        }
        return result;
    }

    void dfs(TreeNode<Integer> root, int vl, TreeMap<Integer, Integer> map) {
        if (root == null) return;

        int sum = map.getOrDefault(vl, 0);
        map.put(vl, sum + root.val);

        dfs(root.left, vl - 1, map);
        dfs(root.right, vl + 1, map);
    }

}
