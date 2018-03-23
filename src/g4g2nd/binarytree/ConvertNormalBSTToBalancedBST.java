package g4g2nd.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ConvertNormalBSTToBalancedBST {

    TreeNode root;
    public static void main(String[] args) {
        /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        ConvertNormalBSTToBalancedBST tree = new ConvertNormalBSTToBalancedBST();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.left.left = new TreeNode(6);
        tree.root.left.left.left.left = new TreeNode(5);

        tree.root = tree.convertToBalncedBST(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }


    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            data = d;
        }
    }

    TreeNode convertToBalncedBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return buildTree(arr);
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }

    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        return buildTree(arr, 0, arr.length-1);
    }

    TreeNode buildTree(int[] arr, int l, int r) {
        if (l > r) return null;

        int m = l + (r-l)/2;
        TreeNode middleNode = new TreeNode(arr[m]);

        TreeNode left = buildTree(arr, l, m-1);
        TreeNode right = buildTree(arr, m+1, r);

        middleNode.left = left;
        middleNode.right = right;

        return middleNode;
    }


}
