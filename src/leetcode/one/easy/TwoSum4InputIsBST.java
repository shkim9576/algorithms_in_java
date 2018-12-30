package leetcode.one.easy;

import java.util.HashSet;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSum4InputIsBST {

    public static void main(String[] args) {
        TwoSum4InputIsBST o = new TwoSum4InputIsBST();

        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(o.findTarget(root, 9));
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(set, root, k);
    }

    boolean helper(HashSet<Integer> set, TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);

        return helper(set, root.left, k) || helper(set, root.right, k);
    }
}
