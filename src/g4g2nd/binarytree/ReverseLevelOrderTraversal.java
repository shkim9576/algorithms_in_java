package g4g2nd.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ReverseLevelOrderTraversal ob = new ReverseLevelOrderTraversal();
        ob.printLevel(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    public void printLevel(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        q.add(root);
        stack.push(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node node = q.remove();
            for (int i = 0; i < size; i++) {
                if (node.right != null) {
                    q.add(node.right);
                    stack.push(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                    stack.push(node.left);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

}
