package g4g.binarytree.excercise;

import java.util.Stack;

public class kSmallest {
    // https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

        kSmallest ob = new kSmallest();
        System.out.println(ob.kSmallest(root, 3));
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    int kSmallest(Node root, int k) {
        if (root == null || k < 1) return -1;

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                if (--k == 0) return node.data;
                curr = node.right;
            }
        }

        return -1;
    }

}
