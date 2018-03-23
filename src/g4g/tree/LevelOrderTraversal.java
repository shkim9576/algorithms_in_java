package g4g.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    // https://www.geeksforgeeks.org/level-order-tree-traversal/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LevelOrderTraversal ob = new LevelOrderTraversal();
        ob.levelOrderTraversal(root);

    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    void levelOrderTraversal(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.remove();
            System.out.print(node.data + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

}
