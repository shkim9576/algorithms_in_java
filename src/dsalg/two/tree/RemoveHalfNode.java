package dsalg.two.tree;

public class RemoveHalfNode {

    public static void main(String[] args) {
        //       4
        //      /  \
        //     2    16
        //    /    /
        //   1    15


        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(16);
        root.left.left = new Node(1);
        root.right.left = new Node(15);

        RemoveHalfNode o = new RemoveHalfNode();
        Node ans = o.removeHalfNode(root);
        o.inorder(ans);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    Node removeHalfNode(Node root) {
        if (root == null) return null;

        root.left = removeHalfNode(root.left);
        root.right = removeHalfNode(root.right);

        if (root.left == null && root.right == null) return root;
        else if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

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
