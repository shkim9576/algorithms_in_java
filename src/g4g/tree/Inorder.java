package g4g.tree;

import java.util.Stack;

public class Inorder {
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Inorder ob = new Inorder();
        ob.inorder(root);
        System.out.println("");
        ob.inorderItr(root);
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    void inorder(TreeNode<Integer> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void inorderItr(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode<Integer> node = stack.pop();
                System.out.print(node.data + " ");
                curr = node.right;
            }
        }
    }

}
