package dsalg.two.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RangePrint {

    public static void main(String[] args) {
        //       4
        //      /  \
        //     2    16
        //    / \  / \
        //   1  3 15  17


        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(16);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(15);
        root.right.right = new Node(17);

        RangePrint o = new RangePrint();
        o.rangePrint(root, 3, 16);
        System.out.println();
        o.rangePrint(root, 0, 10);

        System.out.println();
        o.rangePrintBFS(root, 3, 16);
        System.out.println();
        o.rangePrintBFS(root, 0, 10);
    }

    void rangePrint(Node root, int low, int high) {
        if (root == null) return;

        if (root.data < low) rangePrint(root.right, low, high);
        else if (root.data > high) rangePrint(root.left, low, high);
        else {
            rangePrint(root.left, low, high);
            System.out.print(root.data + " ");
            rangePrint(root.right, low, high);
        }
    }

    void rangePrintBFS(Node root, int low, int high) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.data >= low && n.data <= high) System.out.print(n.data + " ");
            if (n.left != null && n.data >= low) q.add(n.left);
            if (n.right != null && n.data <= high) q.add(n.right);
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
