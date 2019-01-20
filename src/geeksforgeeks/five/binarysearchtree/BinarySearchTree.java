package geeksforgeeks.five.binarysearchtree;

public class BinarySearchTree {

    public Node root;

    public Node insert(Node node, int x) {
        if (node == null) {
            Node n = new Node(x);
            if (this.root == null) this.root = n;
            return n;
        }

        if (node.data <= x) node.right = insert(node.right, x);
        else node.left = insert(node.left, x);

        return node;
    }
}
