package geeksforgeeks.two.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

    Node root;
    public static void main(String[] args) {
        PrintAllPaths tree = new PrintAllPaths();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* Print all root-to-leaf paths of the input tree */
        /*
          1 2 4
          1 2 5
          1 3
         */
        tree.printAllPaths(tree.root);
    }

    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
        }
    }

    void printAllPaths(Node root) {
        if (root == null) return;

        List<Node> path = new ArrayList<>();
        printAllPaths(root, path);
    }

    void printAllPaths(Node root, List<Node> path) {
        if (root == null) return;

        path.add(root);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printAllPaths(root.left, path);
        printAllPaths(root.right, path);
        path.remove(root);
    }

    void printPath(List<Node> path) {
        for (Node n : path) {
            System.out.print(n.data + " ");
        }
        System.out.println();
    }
}
