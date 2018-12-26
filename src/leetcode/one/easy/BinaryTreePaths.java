package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths o = new BinaryTreePaths();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(o.binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, List<String> result, List<String> list) {
        if (root == null) return;

        list.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            result.add(String.join("->", list));
        }

        helper(root.left, result, list);
        helper(root.right, result, list);
        if (!list.isEmpty()) list.remove(list.size() - 1);
    }
}
