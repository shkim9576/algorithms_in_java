package geeksforgeeks.two.binarytree;

public class LCABST {

    Node root;
    public static void main(String[] args) {
        LCABST tree = new LCABST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        /*
        LCA of 10 and 14 is 12
        LCA of 14 and 8 is 8
        LCA of 10 and 22 is 20
         */
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        if (root.data > n1 && root.data < n2) return root;
        if (root.data < n1 && root.data > n2) return root;

        return (root.data > n1) ? lca(root.left, n1, n2) : lca(root.right, n1, n2);
    }

}
