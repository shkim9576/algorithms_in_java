package geeksforgeeks.five.binarysearchtree;

import geeksforgeeks.five.binarytree.Utils;

//https://www.geeksforgeeks.org/remove-leaf-nodes-binary-search-tree/
public class RemoveAllLeaves {

    //5 10 15 20 25 30 35
    //10 20 30
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 15);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 25);
        tree.insert(tree.root, 35);
        inorder(tree.root);
        leafDelete(tree.root);
        System.out.println();
        inorder(tree.root);
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node leafDelete(Node root) {
        if (root == null || root.left == null && root.right == null) return null;
        root.left = leafDelete(root.left);
        root.right = leafDelete(root.right);
        return root;
    }
}
