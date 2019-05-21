package geeksforgeeks.six.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBT {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println("Inorder traversal before deletion : ");
        DeletionInBT o = new DeletionInBT();
        o.inorder(root);

        int key = 11;
        o.deletion(root, key);

        System.out.println("\nInorder traversal after deletion : ");
        o.inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void deletion(Node root, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node temp = null; // right bottom node
        Node targetNode = null;

        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.data == target) {
                targetNode = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }

        targetNode.data = temp.data;
        deleteNode(root, temp);
    }

    void deleteNode(Node root, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node t = q.remove();
            if (t.left == target) {
                t.left = null;
                return;
            }
            if (t.right == target) {
                t.right = null;
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
