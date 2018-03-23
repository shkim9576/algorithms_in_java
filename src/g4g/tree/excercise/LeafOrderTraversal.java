package g4g.tree.excercise;

import java.util.ArrayList;
import java.util.List;

public class LeafOrderTraversal {
    // https://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node root2 = new Node(0);
        root2.left = new Node(1);
        root2.right = new Node(5);
        root2.left.right = new Node(4);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        LeafOrderTraversal ob = new LeafOrderTraversal();
        System.out.println(ob.isSame(root1, root2));
        System.out.println("");

        root1 = new Node(0);
        root1.left = new Node(1);
        root1.right = new Node(2);
        root1.left.left = new Node(8);
        root1.left.right = new Node(9);

        root2 = new Node(1);
        root2.left = new Node(4);
        root2.right = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(2);
        root2.right.right = new Node(9);

        System.out.println(ob.isSame(root1, root2));
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }

    boolean isSame(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        List<Integer> list1 = new ArrayList<>();
        getLeafNodes(n1, list1);
        List<Integer> list2 = new ArrayList<>();
        getLeafNodes(n2, list2);

        System.out.println(list1);
        System.out.println(list2);
        return list1.equals(list2);
    }

    void getLeafNodes(Node root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add((Integer) root.data);

        getLeafNodes(root.left, list);
        getLeafNodes(root.right, list);
    }

}
