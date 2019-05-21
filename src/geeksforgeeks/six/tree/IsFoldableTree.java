package geeksforgeeks.six.tree;

public class IsFoldableTree {

    public static void main(String args[]) {
        IsFoldableTree tree = new IsFoldableTree();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);

        if (tree.isFoldable(root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    boolean isFoldable(Node root) {
        if (root == null) return true;

        return rec(root.left, root.right);
    }

    boolean rec(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;
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
