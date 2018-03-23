package g4g2nd.binarytree;

public class NoSiblings {

    Node root;
    public static void main(String[] args) {
        NoSiblings tree = new NoSiblings();

        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.left.right = new Node(6);

        // 4 5 6
        tree.printSingles(tree.root);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    void printSingles(Node root) {
        if (root == null) return;

        if (root.left == null && root.right != null) System.out.print(root.right.data + " ");
        if (root.right == null && root.left != null) System.out.print(root.left.data + " ");

        printSingles(root.left);
        printSingles(root.right);
    }
}
