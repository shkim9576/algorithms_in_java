package dsalg.two.tree;

public class PrintAncestor {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PrintAncestor o = new PrintAncestor();
        o.printAncestor(root, 7);
    }

    boolean printAncestor(Node root, int t) {
        if (root == null) return false;

        if (root.data == t) {
            System.out.print(root.data + " ");
            return true;
        }

        if (printAncestor(root.left, t) || printAncestor(root.right, t)) {
            System.out.print(root.data + " ");
            return true;
        }

        return false;
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
