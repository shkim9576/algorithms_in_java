package g4g2nd.binarytree;

public class IsFoldableBT {

    Node root;
    public static void main(String[] args) {
        IsFoldableBT tree = new IsFoldableBT();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isFoldable(Node root) {

        if (root == null) return false;

        mirror(root.left);
        return isSameStruct(root.left, root.right);
    }

    void mirror(Node root) {
        if (root == null) return;

        mirror(root.left);
        mirror(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    boolean isSameStruct(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return isSameStruct(n1.left, n2.left) && isSameStruct(n1.right, n2.right);
    }

    boolean isFoldable2(Node root) {

        if (root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }
}
