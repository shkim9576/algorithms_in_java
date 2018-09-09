package g4g1st.tree;

import java.util.Stack;

public class Postorder {
    // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Postorder ob = new Postorder();
        ob.postorder(root);
        System.out.println("");
        ob.postorderItr(root);
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    void postorder(TreeNode<Integer> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    void postorderItr(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> curr = root;

        while (true) {
            if (curr != null) {
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);
                curr = curr.left;
                continue;
            }

            if (stack.isEmpty()) return;
            curr = stack.pop();

            if (curr.right != null && !stack.isEmpty() && curr.right == stack.peek()) {
                stack.pop();
                stack.push(curr);
                curr = curr.right;
            } else {
                System.out.print(curr.data + " ");
                curr = null;
            }
        }
    }

}
