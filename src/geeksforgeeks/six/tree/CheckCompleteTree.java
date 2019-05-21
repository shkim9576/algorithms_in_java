package geeksforgeeks.six.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteTree {

    public static void main(String[] args) {

        /* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        if (isCompleteBT(root) == true)
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
    }

    static boolean isCompleteBT(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left != null) {
                if (flag) return false;
                q.add(n.left);
            } else {
                flag = true;
            }

            if (n.right != null) {
                if (flag) return false;
                q.add(n.right);
            } else {
                flag = true;
            }
        }

        return true;
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
