package dsalg.two.tree;

public class Diameter {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        Diameter o = new Diameter();
        o.height(root);
        System.out.println(max);
    }

    static int max = 0;

    int height(Node root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
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
