package g4g2nd.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBT {

    Node root;
    public static void main(String[] args) {
        MaxWidthBT tree = new MaxWidthBT();

        /*
        Constructed bunary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8
                 /  \
                6   7
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);

        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    int getMaxWidth(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, size);

            for (int i=0; i<size; i++) {
                Node n = q.poll();
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }

        return max;
    }
}
