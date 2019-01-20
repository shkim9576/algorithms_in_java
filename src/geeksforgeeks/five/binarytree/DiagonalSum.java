package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
public class DiagonalSum {

    //[9, 19, 42]
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(6);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(7);
        root.left.right.left = new Node(11);
        root.left.left.right = new Node(10);

        diagonalSum(root);
    }

    static void diagonalSum(Node root) {
        List<Integer> res = new ArrayList<>();
        diagonalSum(root, res, 0);
        System.out.println(res);
    }

    static void diagonalSum(Node root, List<Integer> res, int d) {
        if (root == null) return;
        if (res.size() == d) res.add(0);
        res.set(d, res.get(d) + root.key);

        diagonalSum(root.left, res, d + 1);
        diagonalSum(root.right, res, d);
    }
}
