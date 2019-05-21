package dsalg.two.tree;

public class IsBalanced {

    public static void main(String[] args) {
        //       4
        //      /  \
        //     2    16
        //    / \  / \
        //   1  3 15  17


        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(16);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(15);
        root.right.right = new Node(17);
        root.right.right.right = new Node(20);
        root.right.right.right.right = new Node(25);


        IsBalanced o = new IsBalanced();
        System.out.println(o.isBalanced(root));
    }

    int isBalanced(Node root) {
        if (root == null) return 0;

        int l = isBalanced(root.left);
        if (l == -1) return -1;

        int r = isBalanced(root.right);
        if (r == -1) return -1;

        return Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
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
