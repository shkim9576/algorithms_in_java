package dsalg.two.tree;

public class LCA {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LCA o = new LCA();
        Node lca = o.LCA(root, root.left.left, root.left.right);
        System.out.println(lca.data);
    }

    Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;
        if (root == n1 || root == n2) return root;

        Node l = LCA(root.left, n1, n2);
        Node r = LCA(root.right, n1, n2);

        if (l != null && r != null) return root;
        return l == null ? r : l;
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
