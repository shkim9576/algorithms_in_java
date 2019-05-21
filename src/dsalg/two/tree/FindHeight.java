package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindHeight {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        FindHeight o = new FindHeight();
        System.out.println(o.heightBFS(root));
    }

    int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    int heightBFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            height++;
        }

        return height;
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
