package geeksforgeeks.six.heap;

import java.util.LinkedList;
import java.util.Queue;

public class IsHeap {

    public static void main(String args[]) {
        IsHeap bt = new IsHeap();

        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        if (bt.isHeap(root) == true)
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    }

    boolean isHeap(Node root) {
        return isComplete(root) && isHeapRec(root);
    }

    boolean isHeapRec(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data) return false;
        if (root.right != null && root.right.data > root.data) return false;

        return isHeapRec(root.left) && isHeapRec(root.right);
    }

    boolean isComplete(Node root) {
        if (root == null) return true;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (n.left == null) {
                    flag = true;
                } else {
                    if (flag) return false;
                    q.add(n.left);
                }

                if (n.right == null) {
                    flag = true;
                } else {
                    if (flag) return false;
                    q.add(n.right);
                }
            }
        }

        return true;
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
