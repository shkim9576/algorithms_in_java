package dsalg.two.tree;

public class RemoveLeaves {

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

        RemoveLeaves o = new RemoveLeaves();
        Node ans = o.removeLeaves(root);
        o.inorder(ans);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    Node removeLeaves(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

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
