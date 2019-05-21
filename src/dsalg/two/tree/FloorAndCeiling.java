package dsalg.two.tree;

public class FloorAndCeiling {

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

        FloorAndCeiling o = new FloorAndCeiling();
        System.out.println(o.floor(root, 0));
        System.out.println(o.floor(root, 1).data);
        System.out.println(o.floor(root, 5).data);
        System.out.println(o.floor(root, 20));

        System.out.println();
        System.out.println(o.ceiling(root, 0).data);
        System.out.println(o.ceiling(root, 1).data);
        System.out.println(o.ceiling(root, 5).data);
        System.out.println(o.ceiling(root, 20));
    }

    Node floor(Node root, int x) {
        return floorRec(root, x, null);
    }

    Node floorRec(Node root, int x, Node prev) {
        if (root == null) return null;

        Node left = floorRec(root.left, x, prev);

        if (left != null) return left;

        if (root.data == x) {
            return root;
        } else if (root.data > x) {
            return prev;
        }

        return floorRec(root.right, x, root);
    }

    Node ceiling(Node root, int x) {
        return ceilingRec(root, x, null);
    }

    Node ceilingRec(Node root, int x, Node prev) {
        if (root == null) return null;

        Node right = ceilingRec(root.right, x, prev);

        if (right != null) return right;

        if (root.data == x) {
            return root;
        } else if (root.data < x) {
            return prev;
        }

        return floorRec(root.left, x, root);
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
