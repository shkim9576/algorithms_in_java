package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LevelSum o = new LevelSum();
        o.levelSum(root);
    }

    void levelSum(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                sum += n.data;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            System.out.print(sum + " ");
        }
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
