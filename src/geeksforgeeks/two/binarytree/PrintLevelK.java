package geeksforgeeks.two.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelK {

    Node root;
    public static void main(String[] args) {
        PrintLevelK tree = new PrintLevelK();

        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        // 4 5 8
        tree.printKDistantDFS(tree.root, 2);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    void printKDistantDFS(Node root, int k) {
        if (root == null) return;

        if (k == 0) {
            System.out.print(root.data + " ");
        }

        printKDistantDFS(root.left, k-1);
        printKDistantDFS(root.right, k-1);
    }

    void printKDistantBFS(Node root, int k) {

        if (root == null || k < 0) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {

                if (k < 0) return;

                Node n  = q.poll();
                if (k == 0) {
                    System.out.print(n.data + " ");
                } else {
                    if (n.left != null) q.offer(n.left);
                    if (n.right != null) q.offer(n.right);
                }
            }
            k--;
        }
    }
}
