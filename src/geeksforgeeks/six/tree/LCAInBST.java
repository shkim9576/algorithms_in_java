package geeksforgeeks.six.tree;

public class LCAInBST {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(8);
        root.right.right = new Node(10);
        root.right.left = new Node(5);
        root.right.left.right = new Node(7);
        root.right.left.right.left = new Node(6);

        LCAInBST o = new LCAInBST();
        System.out.println(o.LCAinBST(root, root.right.right, root.right.left.right.left).data);
    }

    Node LCAinBST(Node root, Node a, Node b) {
        if (root == null || root == a || root == b) return root;

        if (root.data > a.data && root.data > b.data) return LCAinBST(root.left, a, b);
        else if (root.data < a.data && root.data < b.data) return LCAinBST(root.right, a, b);

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
