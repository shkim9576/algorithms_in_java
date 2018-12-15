package geeksforgeeks.two.bst;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node root = tree.sortedArrayToBST(arr);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    Node sortedArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        return helper(arr, 0, arr.length-1);
    }

    Node helper(int[] arr, int l, int r) {
        if (l > r) return null;

        int m = l + (r-l) / 2;
        Node root = new Node(arr[m]);
        root.left = helper(arr, l, m-1);
        root.right = helper(arr, m+1, r);
        return root;
    }

}
