package geeksforgeeks.five.binarytree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LowestCommonAncestor {

    //LCA(4, 5): 2
    //LCA(4, 6): 1
    //LCA(3, 4): 1
    //LCA(2, 4): 2
    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(tree.root,4, 5));
        System.out.println("LCA(4, 6): " + tree.findLCA(tree.root, 4, 6));
        System.out.println("LCA(3, 4): " + tree.findLCA(tree.root,3, 4));
        System.out.println("LCA(2, 4): " + tree.findLCA(tree.root,2, 4));
    }

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static class Solution {

        Node root;

        int findLCA(Node root, int a, int b) {
           if (root == null) return -1;
            if (root.data == a || root.data == b) return root.data;

           int l = findLCA(root.left, a, b);
           int r = findLCA(root.right, a, b);

           if (l > 0 && r > 0) return root.data;
           return l > 0 ? l : r;
        }
    }
}
