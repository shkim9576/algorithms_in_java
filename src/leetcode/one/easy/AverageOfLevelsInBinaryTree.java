package leetcode.one.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree o = new AverageOfLevelsInBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(o.averageOfLevels(root)); //[3.0, 14.5, 11.0]
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                sum += n.val;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            result.add(sum / size);
        }

        return result;
    }
}
