package g4g1st.tree.excercise;

public class BoundaryTraversal {
    // https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        BoundaryTraversal ob = new BoundaryTraversal();
        ob.printBoundary(root); // 20 8 4 10 14 25 22
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    void printBoundary(Node<Integer> root) {
        if (root == null) return;

        printLeft(root);
        printLeaves(root);
        if (root != null) printRight(root.right);
    }

    boolean isLeaf(Node<Integer> root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    void printLeft(Node<Integer> root) {
        if (root == null) return;

        if (!isLeaf(root)) {
            System.out.print(root.data + " ");
            printLeft(root.left);
        }
    }

    void printRight(Node<Integer> root) {
        if (root == null) return;

        printRight(root.right);
        if (!isLeaf(root)) System.out.print(root.data + " ");
    }

    void printLeaves(Node<Integer> root) {
        if (root == null) return;

        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeaves(root.left);
        printLeaves(root.right);
    }

}
