package geeksforgeeks.five.binarysearchtree;

public class BinaryTree {

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (root.data <= data) root.right = insert(root.right, data);
        else root.left = insert(root.left, data);

        return root;
    }
}
