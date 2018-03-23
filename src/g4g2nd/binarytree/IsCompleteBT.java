package g4g2nd.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBT {

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

        IsCompleteBT ob = new IsCompleteBT();
        if(ob.isCompleteBT(root))
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
    }


    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isCompleteBT(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;

        while(!q.isEmpty()) {
            Node n = q.poll();
            if (n.left != null) {
                if (flag) return false;
                q.offer(n.left);
            } else {
                flag = true;
            }

            if (n.right != null) {
                if (flag) return false;
                q.offer(n.right);
            } else {
                flag = true;
            }
        }

        return true;
    }

}
