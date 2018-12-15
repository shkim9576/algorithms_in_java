package geeksforgeeks.two.binarytree;

public class MaxHeight {

    Node root;
    public static void main(String[] args) {
        MaxHeight tree = new MaxHeight();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
        }
    }

    int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.max(leftH, rightH) + 1;
    }
}
