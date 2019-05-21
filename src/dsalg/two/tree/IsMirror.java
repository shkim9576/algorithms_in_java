package dsalg.two.tree;

public class IsMirror {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

        Node root2 = new Node(1);
        root2.right = new Node(2);
        root2.right.right = new Node(4);
        root2.right.left = new Node(5);
        root2.left = new Node(3);

        IsMirror o = new IsMirror();
        System.out.println(o.isMirror(root, root2));
    }

    boolean isMirror(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return n1.data == n2.data && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
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
