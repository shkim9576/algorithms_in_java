package geeksforgeeks.five.binarysearchtree;

import geeksforgeeks.one.search.BinarySearch;

//https://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/
public class CheckIfSubsequenceExist {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 14);
        tree.insert(tree.root, 13);

        int[] seq = {4, 6, 8, 14};
        System.out.println(seqExist(tree.root, seq));
    }

    static int index = 0;

    static boolean seqExist(Node root, int[] A) {
        inorder(root, A);
        return index == A.length;
    }

    static void inorder(Node root, int[] A) {
        if (root == null) return;

        if (index < A.length) {
            inorder(root.left, A);
            if (root.data == A[index]) index++;
            inorder(root.right, A);
        }
    }
}
