package geeksforgeeks.two.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    Node root;
    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        LeftView tree = new LeftView();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        // 12      10      25
        tree.printLeftView(tree.root);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    void printLeftView (Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node n = q.remove();
                if (i == size-1) {
                    System.out.print(n.data + " ");
                }
                if (n.right != null) q.add(n.right);
                if (n.left != null) q.add(n.left);
            }
        }
    }
}
