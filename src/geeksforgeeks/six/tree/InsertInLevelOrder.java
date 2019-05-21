package geeksforgeeks.six.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInLevelOrder {

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        InsertInLevelOrder o = new InsertInLevelOrder();

        System.out.print("Inorder traversal before insertion:");
        o.inorder(root);

        int key = 12;
        o.insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        o.inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void insert(Node root, int key) {
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left != null) {
                q.add(n.left);
            } else {
                n.left = new Node(key);
                return;
            }

            if (n.right != null) {
                q.add(n.right);
            } else {
                n.right = new Node(key);
                return;
            }
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
