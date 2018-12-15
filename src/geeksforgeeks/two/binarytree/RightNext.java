package geeksforgeeks.two.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RightNext {

    Node root;

    public static void main(String[] args) {
        RightNext tree = new RightNext();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.right.right = new Node(5);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(4);

        /*
        No next right node found for 10
        Next Right of 2 is 6
        No next right node found for 6
        No next right node found for 5
        Next Right of 8 is 4
        Next Right of 4 is 5
         */
        tree.test(tree.root, 10);
        tree.test(tree.root, 2);
        tree.test(tree.root, 6);
        tree.test(tree.root, 5);
        tree.test(tree.root, 8);
        tree.test(tree.root, 4);
    }

    void test(Node node, int k) {
        Node nr = nextRight(root, k);
        if (nr != null)
            System.out.println("Next Right of " + k + " is " + nr.data);
        else
            System.out.println("No next right node found for " + k);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    Node nextRight(Node root, int target) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (flag) {
                    return n;
                }
                if (n.data == target) {
                    if (i == size - 1) return null;
                    flag = true;
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }

        return null;
    }
}
