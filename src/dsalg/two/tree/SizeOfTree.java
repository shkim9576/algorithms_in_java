package dsalg.two.tree;

public class SizeOfTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        SizeOfTree o = new SizeOfTree();
        System.out.println(o.size(root));
    }

    int size(Node root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
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
