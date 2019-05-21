package dsalg.two.tree;

public class Mirror {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

        Mirror o = new Mirror();
        o.inorder(root);
        System.out.println();
        o.mirror(root);
        o.inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void mirror(Node root) {
        if (root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
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
