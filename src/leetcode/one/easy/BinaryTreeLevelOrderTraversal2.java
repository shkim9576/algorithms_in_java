package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversal2 {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 o = new BinaryTreeLevelOrderTraversal2();

        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(4);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);
        n1.right.right.right = new TreeNode(5);

        List<List<Integer>> result = o.levelOrderBottom(n1);
        System.out.println(result); //[[5], [3, 4, 4, 3], [2, 2], [1]]
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottomHelper(root, result, 0);
        return result;
    }

    public void levelOrderBottomHelper(TreeNode root, List<List<Integer>> result, int level) {
        if (root != null) {
            if (result.size() <= level) result.add(0, new ArrayList<>());

            levelOrderBottomHelper(root.left, result, level + 1);
            levelOrderBottomHelper(root.right, result, level + 1);

            result.get(result.size() - level - 1).add(root.val);
        }
    }
}
