package geeksforgeeks.six.tree;

import java.util.Stack;

public class InorderWithStack {

    public static void main(String args[]) {

        /* creating a binary tree and entering
        the nodes */
        InorderWithStack tree = new InorderWithStack();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        tree.inorder(root);
    }

    void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");

            curr = curr.right;
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
