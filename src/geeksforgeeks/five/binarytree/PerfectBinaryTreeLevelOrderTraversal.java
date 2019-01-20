package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
public class PerfectBinaryTreeLevelOrderTraversal {

    //Specific Level Order traversal of binary tree is
    //1 2 3 4 7 5 6 8 15 9 14 10 13 11 12 16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        tree.root.left.left.left.left = new Node(16);
        tree.root.left.left.left.right = new Node(17);
        tree.root.left.left.right.left = new Node(18);
        tree.root.left.left.right.right = new Node(19);
        tree.root.left.right.left.left = new Node(20);
        tree.root.left.right.left.right = new Node(21);
        tree.root.left.right.right.left = new Node(22);
        tree.root.left.right.right.right = new Node(23);
        tree.root.right.left.left.left = new Node(24);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.left.right.left = new Node(26);
        tree.root.right.left.right.right = new Node(27);
        tree.root.right.right.left.left = new Node(28);
        tree.root.right.right.left.right = new Node(29);
        tree.root.right.right.right.left = new Node(30);
        tree.root.right.right.right.right = new Node(31);

        System.out.println("Specific Level Order traversal of binary tree is ");
        tree.printSpecificLevelOrder(tree.root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        void printSpecificLevelOrder(Node node) {
            if (node == null) return;
            System.out.print(node.data + " ");

            Queue<Node> ql = new LinkedList<>();
            Queue<Node> qr = new LinkedList<>();

            if (node.left != null) ql.add(node.left);
            if (node.right != null) qr.add(node.right);

            while (!ql.isEmpty() || !qr.isEmpty()) {
                Node l = ql.remove();
                Node r = qr.remove();

                System.out.print(l.data + " ");
                System.out.print(r.data + " ");
                if (l.left != null) ql.add(l.left);
                if (l.right != null) ql.add(l.right);
                if (r.right != null) qr.add(r.right);
                if (r.left != null) qr.add(r.left);
            }
        }
    }
}
