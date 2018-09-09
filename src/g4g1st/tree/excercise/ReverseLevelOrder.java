package g4g1st.tree.excercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    // https://www.geeksforgeeks.org/reverse-level-order-traversal/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ReverseLevelOrder ob = new ReverseLevelOrder();
        ob.reverseLevelOrder(root);
        System.out.println("");
        ob.reverseLevelOrderStack(root);
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    void reverseLevelOrder(TreeNode<Integer> root) {
        if (root == null) return;

        int height = getHeight(root);
        for (int i = height; i >= 1; i--) {
            printLevel(root, i);
        }
    }

    void printLevel(TreeNode<Integer> root, int level) {
        if (root == null) return;
        if (level == 1) System.out.print(root.data + " ");
        if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    int getHeight(TreeNode<Integer> root) {
        if (root == null) return 0;

        int left = 0;
        int right = 0;
        if (root.left != null) left = getHeight(root.left);
        if (root.right != null) right = getHeight(root.right);

        return left > right ? left + 1 : right + 1;
    }

    void reverseLevelOrderStack(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        Stack<TreeNode<Integer>> stack = new Stack<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.remove();
            stack.push(node);
            if (node.right != null) q.add(node.right);
            if (node.left != null) q.add(node.left);
        }

        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            System.out.print(node.data + " ");
        }
    }

}
