package g4g2nd.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    Node root;
    public static void main(String[] args) {
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        // 1 3 7 8
        tree.rightView(tree.root);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    void rightView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node n = q.remove();
                if (i == size-1) {
                    System.out.print(n.data + " ");
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
    }
}
