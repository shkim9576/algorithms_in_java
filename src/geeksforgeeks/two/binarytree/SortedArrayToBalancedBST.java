package geeksforgeeks.two.binarytree;

public class SortedArrayToBalancedBST {


    public static void main(String[] args) {
        SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = tree.buildTree(arr);

        tree.inOrder(root);
        System.out.println();
        // 4 2 1 3 6 5 7
        tree.preOrder(root);
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            data = d;
        }
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
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
