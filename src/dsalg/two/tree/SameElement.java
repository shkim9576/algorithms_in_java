package dsalg.two.tree;

import java.util.LinkedList;
import java.util.List;

public class SameElement {

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

        SameElement o = new SameElement();
        System.out.println(o.isSameElementRec(root, root));
    }

    boolean isSameElementRec(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return n1.data == n2.data && isSameElementRec(n1.left, n2.left) && isSameElementRec(n1.right, n2.right);
    }

    boolean isSameElement(Node n1, Node n2) {
        if (n1 == null || n2 == null) return n1 == n2;

        List<Integer> list = new LinkedList<>();
        inorderAdd(n1, list);

        return inorderRemove(n2, list) && list.isEmpty();
    }

    boolean inorderRemove(Node root, List<Integer> list) {
        if (root != null) {
            boolean l = inorderRemove(root.left, list);
            if (!l) return false;

            if (!list.contains(root.data)) return false;
            list.remove(Integer.valueOf(root.data));

            boolean r = inorderRemove(root.right, list);
            if (!r) return false;
        }

        return true;
    }

    void inorderAdd(Node root, List<Integer> list) {
        if (root != null) {
            inorderAdd(root.left, list);
            list.add(Integer.valueOf(root.data));
            inorderAdd(root.right, list);
        }
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
