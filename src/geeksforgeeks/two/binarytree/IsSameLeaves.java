package geeksforgeeks.two.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IsSameLeaves {

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

        IsSameLeaves ob = new IsSameLeaves();
        System.out.println(ob.isSameLeaf(root1, root2));
    }

    static class Node implements Comparable<Node> {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }

        public int compareTo(Node node) {
            return this.data - node.data;
        }

        public int hashCode() {
            return Objects.hash(data);
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node)o;
            return n.data == this.data;
        }
    }

    boolean isSameLeaf(Node node1, Node node2) {
        List<Node> list1 = getLeaves(node1);
        List<Node> list2 = getLeaves(node2);
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    List<Node> getLeaves(Node root) {
        List<Node> list = new ArrayList<>();
        getLeaves(root, list);
        return list;
    }

    void getLeaves(Node root, List<Node> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root);

        getLeaves(root.left, list);
        getLeaves(root.right, list);
    }

}
