package geeksforgeeks.one.tree;

import java.util.Stack;

public class Preorder {
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Preorder ob = new Preorder();
        ob.preorder(root);
        System.out.println("");
        ob.preorderItr(root);
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    void preorder(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void preorderItr(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

}
