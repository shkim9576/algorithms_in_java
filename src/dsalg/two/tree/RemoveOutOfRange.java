package dsalg.two.tree;

public class RemoveOutOfRange {

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

        RemoveOutOfRange o = new RemoveOutOfRange();
        Node ans = o.removeOutOfRange(root, 3, 16);
        o.inorder(ans);

        System.out.println();
        ans = o.removeOutOfRange(root, 5, 15);
        o.inorder(ans);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    Node removeOutOfRange(Node root, int min, int max) {
        if (root == null) return null;

        root.left = removeOutOfRange(root.left, min, max);
        root.right = removeOutOfRange(root.right, min, max);

        if (root.data < min) return root.right;
        if (root.data > max) return root.left;

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
