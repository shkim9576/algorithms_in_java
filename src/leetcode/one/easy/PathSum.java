package leetcode.one.easy;

//https://leetcode.com/problems/path-sum/submissions/
public class PathSum {

    public static void main(String[] args) {
        PathSum o = new PathSum();
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(2);
        n1.right.left = new TreeNode(4);
        n1.right.right = new TreeNode(3);
        n1.right.right.right = new TreeNode(5);

        System.out.println(o.hasPathSum(n1, 11)); //true
        System.out.println(o.hasPathSum(n1, 12)); //false
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
