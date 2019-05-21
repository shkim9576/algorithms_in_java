package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElement2 {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        SearchElement2 o = new SearchElement2();
        System.out.println(o.search(root, 3));
        System.out.println(o.search(root, 8));
    }

    boolean search(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.data == key) return true;
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }

        return false;
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
