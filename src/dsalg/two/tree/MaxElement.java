package dsalg.two.tree;

public class MaxElement {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        MaxElement o = new MaxElement();
        System.out.println(o.max(root));
    }

    int max(Node root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return root.data;

        int l = max(root.left);
        int r = max(root.right);

        return Math.max(root.data, Math.max(l, r));
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
