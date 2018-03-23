package g4g2nd.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBTItr {

    Node root;
    public static void main(String[] args) {
        HeightOfBTItr tree = new HeightOfBTItr();

        // Let us create a binary tree shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        // Height of tree is 3
        System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    int treeHeight(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int height = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node n = q.poll();
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            height++;
        }

        return height;
    }

}
