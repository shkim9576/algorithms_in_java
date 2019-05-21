package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElement2 {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        MaxElement2 o = new MaxElement2();
        System.out.println(o.max(root));
    }

    int max(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int max = 0;
        while (!q.isEmpty()) {
            Node n = q.remove();
            max = Math.max(max, n.data);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return max;
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
