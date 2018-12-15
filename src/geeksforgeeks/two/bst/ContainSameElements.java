package geeksforgeeks.two.bst;

import java.util.HashSet;
import java.util.Set;

public class ContainSameElements {

    public static void main(String[] args) {
        // First BST
        Node root1 = new Node(15);
        root1.left = new Node(10);
        root1.right = new Node(20);
        root1.left.left = new Node(5);
        root1.left.right = new Node(12);
        root1.right.right = new Node(25);

        // Second BST
        Node root2 = new Node(15);
        root2.left = new Node(12);
        root2.right = new Node(20);
        root2.left.left = new Node(5);
        root2.left.left.right = new Node(10);
        root2.right.right = new Node(25);

        ContainSameElements ob = new ContainSameElements();
        boolean res = ob.sameSet(root1, root2);
        System.out.println(res);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean sameSet(Node n1, Node n2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        preorder(n1, s1);
        preorder(n2, s2);
        return s1.equals(s2);
    }

    void preorder(Node n, Set<Integer> s) {
        if (n != null) {
            s.add(n.data);
            preorder(n.left, s);
            preorder(n.right, s);
        }
    }
}
