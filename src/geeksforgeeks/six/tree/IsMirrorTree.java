package geeksforgeeks.six.tree;

public class IsMirrorTree {

    public static void main(String args[]) {
        IsMirrorTree tree = new IsMirrorTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        boolean output = tree.isSymmetric(root);
        System.out.println(output);
    }

    boolean isSymmetric(Node root) {
        if (root == null) return true;

        return rec(root.left, root.right);
    }

    boolean rec(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;

        if (n1.data != n2.data) return false;

        return rec(n1.left, n2.right) && rec(n1.right, n2.left);
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
