package dsalg.two.tree;

import java.util.TreeMap;

public class VerticalSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        VerticalSum o = new VerticalSum();
        o.verticalSum(root);
    }

    void verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dfs(root, 0, map);

        for (int n : map.values()) {
            System.out.print(n + " ");
        }
    }

    void dfs(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null) return;

        map.put(level, map.getOrDefault(level, 0) + root.data);
        dfs(root.left, level - 1, map);
        dfs(root.right, level + 1, map);
    }


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }
}
