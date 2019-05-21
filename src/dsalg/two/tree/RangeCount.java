package dsalg.two.tree;

public class RangeCount {

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

        RangeCount o = new RangeCount();
        System.out.println(o.rangeCount(root, 3, 17));
    }

    int rangeCount(Node root, int min, int max) {
        if (root == null) return 0;

        int count = 0;
        if (root.data >= min && root.data <= max) count++;

        if (root.data <= max) {
            count += rangeCount(root.right, min, max);
        }

        if (root.data >= min) {
            count += rangeCount(root.left, min, max);
        }

        return count;
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
