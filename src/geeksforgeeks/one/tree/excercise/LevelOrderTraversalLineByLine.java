package geeksforgeeks.one.tree.excercise;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
    // https://www.geeksforgeeks.org/print-level-order-traversal-line-line/

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LevelOrderTraversalLineByLine ob = new LevelOrderTraversalLineByLine();
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

            int size = q.size();
            while (size > 0) {
                TreeNode<Integer> node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size--;
            }

            System.out.println("");
        }
    }

}
