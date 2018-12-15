package geeksforgeeks.two.bst;

public class IsBST {

    Node root;
    public static void main(String[] args) {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean helper(Node root, int min, int max) {
        if (root == null) return true;

        return root.data > min && root.data < max && helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }
}
