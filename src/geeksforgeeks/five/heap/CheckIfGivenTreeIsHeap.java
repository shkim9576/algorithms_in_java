package geeksforgeeks.five.heap;

import geeksforgeeks.five.binarysearchtree.BinarySearchTree;

//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
public class CheckIfGivenTreeIsHeap {

    public static void main(String args[]) {
        BinarySearchTree bt = new BinarySearchTree();

        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        if (isHeap(root) == true)
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    }

    static boolean isHeap(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return false;
        if (root.left != null && root.data < root.left.data ||
                root.right != null && root.data < root.right.data) return false;

        return isHeap(root.left) && isHeap(root.right);
    }

}
