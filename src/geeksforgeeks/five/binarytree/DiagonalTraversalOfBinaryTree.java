package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class DiagonalTraversalOfBinaryTree {

    //Diagonal Traversal of binary tree :
    // 8 10 14
    // 3 6 7 13
    // 1 4
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalPrint(root);
    }

    static void diagonalPrint(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        diagonalPrint(root, res, 0);
        System.out.println(res);
    }

    static void diagonalPrint(Node root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() <= depth) res.add(new ArrayList<>());

        diagonalPrint(root.left, res, depth + 1);
        res.get(depth).add(root.key);
        diagonalPrint(root.right, res, depth);
    }
}
