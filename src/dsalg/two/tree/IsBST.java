package dsalg.two.tree;

public class IsBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.right = new Node(30);

        IsBST o = new IsBST();
        System.out.println(o.isBST(root));
    }

    boolean isBST(Node root) {
        if (root == null) return true;

        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTRec(Node root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return isBSTRec(root.left, min, root.data) && isBSTRec(root.right, root.data, max);
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
