package dsalg.two.tree;

public class KSmallestInBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(15);
        root.right.right = new Node(30);

        KSmallestInBST o = new KSmallestInBST();
        Node ans = o.kSmallestInBST(root, 5);
        System.out.println(ans.data);
    }

    int count;

    Node kSmallestInBST(Node root, int k) {
        if (root == null) return null;
        Node left = kSmallestInBST(root.left, k);
        if (left != null) return left;

        if (++count == k) return root;

        return kSmallestInBST(root.right, k);
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
