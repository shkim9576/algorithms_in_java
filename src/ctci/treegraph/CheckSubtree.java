package ctci.treegraph;

import java.util.ArrayList;
import java.util.List;

public class CheckSubtree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        Node r2 = new Node(2);
        r2.left = new Node(4);
        r2.right = new Node(5);

        CheckSubtree ob = new CheckSubtree();
        System.out.println(ob.isSubTree(root, r2));
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }


    boolean isSubTree(Node t1, Node t2) {
        List<Integer> list1 = new ArrayList<>();
        buildNodeList(t2, list1);

        Node t2FromT1 = find(t1, t2);

        List<Integer> list2 = new ArrayList<>();
        buildNodeList(t2FromT1, list2);

        return list1.equals(list2);
    }

    Node find(Node n1, Node n2) {
        if (n1 == null || n1.val == n2.val) return n1;

        Node n = find(n1.left, n2);
        if (n != null) return n;
        return find(n1.right, n2);
    }

    void buildNodeList(Node n, List<Integer> list) {
        if (n == null) {
            list.add(-1);
        } else {
            list.add(n.val);
            buildNodeList(n.left, list);
            buildNodeList(n.right, list);
        }
    }

}
