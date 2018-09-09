package g4g1st.tree.excercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
    // https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        DiagonalTraversal ob = new DiagonalTraversal();
        Map<Integer, List<Integer>> result = ob.diagonal(root);
        System.out.println(result);
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    Map<Integer, List<Integer>> diagonal(TreeNode<Integer> root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null) return map;

        diagonal(root, map, 0);
        return map;
    }

    void diagonal(TreeNode<Integer> root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) return;

        List<Integer> list = map.getOrDefault(level, new LinkedList<>());
        list.add(root.data);
        map.put(level, list);

        diagonal(root.left, map, level + 1);
        diagonal(root.right, map, level);
    }

}
