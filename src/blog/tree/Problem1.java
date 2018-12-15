package blog.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 p = new Problem1();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        p.printVerticalOrder(root);
    }

    public void printVerticalOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        dfs(root, 0, map);
        printTree(map);
    }

    public void dfs(TreeNode root, int level, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> list = map.getOrDefault(level, new ArrayList<>());
        list.add(root.data);
        map.put(level, list);  // map.put add new item if not exist.

        dfs(root.left, level - 1, map);
        dfs(root.right, level + 1, map);
    }

    public void printTree(TreeMap<Integer, ArrayList<Integer>> map) {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i : entry.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
