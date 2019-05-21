package geeksforgeeks.six.tree;

import java.util.Stack;

public class SpiralTraversal {

    public static void main(String[] args) {
        SpiralTraversal tree = new SpiralTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal(root);
    }

    void printZigZagTraversal(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(root);

        while (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                Node node = s1.pop();
                System.out.print(node.data + " ");
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }

            while (!s2.isEmpty()) {
                Node node = s2.pop();
                System.out.print(node.data + " ");
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
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
