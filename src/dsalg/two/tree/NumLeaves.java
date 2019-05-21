package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NumLeaves {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        NumLeaves o = new NumLeaves();
        System.out.println(o.numLeaves(root));
        System.out.println(o.numLeavesBFS(root));
    }

    int numLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return numLeaves(root.left) + numLeaves(root.right);
    }

    int numLeavesBFS(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int leaves = 0;
        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left == null && n.right == null) leaves++;
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }

        return leaves;
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
