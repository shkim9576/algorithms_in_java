package geeksforgeeks.five.binarytree;

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
public class BoundaryTraversalOfBinaryTree {

    //20 8 4 10 14 25 22
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        void printBoundary(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            printLeft(root.left);
            printLeaves(root);
            printRight(root.right);
        }
    }

    static void printLeft(Node root) {
        if (root == null) return;

        if (root.left != null) {
            System.out.print(root.data + " ");
            printLeft(root.left);
        }
        else if (root.right != null) {
            System.out.print(root.data + " ");
            printLeft(root.right);
        }
    }

    static void printRight(Node root) {
        if (root == null) return;

        if (root.right != null) {
            printRight(root.right);
            System.out.print(root.data + " ");
        }
        else if (root.left != null) {
            printRight(root.left);
            System.out.print(root.data + " ");
        }
    }

    static void printLeaves(Node root) {
        if (root == null) return;
        printLeaves(root.left);
        if (root.left == null && root.right == null) System.out.print(root.data + " ");
        printLeaves(root.right);
    }

}
