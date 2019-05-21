package dsalg.two.tree;

public class InPreToBinaryTree {

    public static void main(String[] args) {
        String[] in = {"D", "B", "E", "A", "F", "C"};
        String[] pre = {"A", "B", "D", "E", "C", "F"};

        InPreToBinaryTree o = new InPreToBinaryTree();
        Node bt = o.build(in, pre, 0, in.length - 1);
        o.inorder(bt);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }


    Node build(String[] in, String[] pre, int start, int end) {
        if (start < end) {
            int ri = find(in, pre[0]);

            Node root = new Node(in[ri]);
            root.left = build(in, pre, start, ri - 1);
            root.right = build(in, pre, ri + 1, end);

            return root;
        }

        return null;
    }

    int find(String[] in, String t) {
        for (int i = 0; i < in.length; i++) {
            if (in[i].equals(t)) return i;
        }
        return 0;
    }

    static class Node {
        String data;
        Node left;
        Node right;

        Node(String d) {
            this.data = d;
        }
    }
}
