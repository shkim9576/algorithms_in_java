package geeksforgeeks.two.binarytree;

public class BoundaryTraversal {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        // 20 8 4 10 14 25 22
        BoundaryTraversal ob = new BoundaryTraversal();
        ob.printBoundary(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    void printBoundary(Node root) {
        if (root == null) return;

        printLeft(root);
        printLeaves(root);
        printRight(root.right);
    }

    void printLeft(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        if (!isLeaf(root.left)) printLeft(root.left);
    }

    void printRight(Node root) {
        if (root == null) return;

        printRight(root.right);
        if (!isLeaf(root)) System.out.print(root.data + " ");
    }

    void printLeaves(Node root) {
        if (root == null) return;

        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeaves(root.left);
        printLeaves(root.right);
    }

    boolean isLeaf(Node node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }


}
