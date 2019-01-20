package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-level-order-traversal/
public class ReverseLevelOrderTraversal {

    //Level Order traversal of binary tree is
    //4 5 2 3 1
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level Order traversal of binary tree is (#1) : ");
        tree.reverseLevelOrder(tree.root);

        System.out.println("\nLevel Order traversal of binary tree is (#2) : ");
        tree.reverseLevelOrderUsingStack(tree.root);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right;
        }
    }

    static class BinaryTree {
        Node root;

        // Method 1 - O(N^2)
        void reverseLevelOrder(Node root) {
            int height = getHeight(root);
            for (int i = height; i >= 0; i--) {
                printLevel(root, i);
            }
        }

        int getHeight(Node root) {
            if (root == null) return 0;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }

        void printLevel(Node root, int level) {
            if (root == null) return;

            if (level == 1) System.out.print(root.data + " ");
            else if (level > 1) {
                printLevel(root.left, level - 1);
                printLevel(root.right, level - 1);
            }
        }

        // Method 2 - O(n)
        void reverseLevelOrderUsingStack(Node root) {
            Stack<Node> stack = new Stack<>();
            Queue<Node> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
                Node n = q.remove();
                stack.push(n);
                if (n.right != null) q.add(n.right);
                if (n.left != null) q.add(n.left);
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop().data + " ");
            }
        }
    }
}
