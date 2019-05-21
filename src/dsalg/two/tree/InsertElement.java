package dsalg.two.tree;

public class InsertElement {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        InsertElement o = new InsertElement();
        o.insert(root, 8);

        o.inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        if (root.left == null) {
            root.left = new Node(key);
            return root;
        }

        if (root.right == null) {
            root.right = new Node(key);
            return root;
        }

        if (root.data >= key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }

        return root;
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
