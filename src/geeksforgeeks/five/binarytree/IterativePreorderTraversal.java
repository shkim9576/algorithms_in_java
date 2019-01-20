package geeksforgeeks.five.binarytree;

import java.util.Stack;

//https://www.geeksforgeeks.org/iterative-preorder-traversal/
public class IterativePreorderTraversal {

    //             10
    //            /   \
    //           8     2
    //          / \   /
    //         3   5 7
    public static void main(String args[]) {
        IterativePreorderTraversal tree = new IterativePreorderTraversal();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(7);
        tree.iterativePreorder(tree.root);
    }

    Node root;

    void iterativePreorder(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.data + " ");
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
    }

    static class Node {

        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
