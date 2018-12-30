package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilarTrees {

    public static void main(String[] args) {
        LeafSimilarTrees o = new LeafSimilarTrees();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(6);
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(6);

        System.out.println(o.leafSimilar(root1, root2)); //true
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        return list1.equals(list2);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        if (root.left == null && root.right == null) list.add(root.val);
        inorder(root.right, list);
    }
}
