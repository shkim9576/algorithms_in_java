package geeksforgeeks.two.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeftNode {

    Node root;
    public static void main(String[] args) {
        DeepestLeftNode tree = new DeepestLeftNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.root.right.left.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);

        Node result = tree.deepestLeftLeaf(tree.root);
        if (result != null)
            System.out.println("The deepest left child"+
                               " is " + result.data);
        else
            System.out.println("There is no left leaf in"+
                               " the given tree");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    Node deepestLeftLeaf(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node n = null;
        while(!q.isEmpty()) {
            n = q.poll();
            if (n.right != null) q.add(n.right);
            if (n.left != null) q.add(n.left);
        }
        return n;
    }
}
