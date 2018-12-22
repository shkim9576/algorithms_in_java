package leetcode.one.easy;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        ConvertSortedArrayToBST o = new ConvertSortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = o.sortedArrayToBST(nums);
        o.inOrder(result);
    }

    public void inOrder(TreeNode n) {
        if (n != null) {
            inOrder(n.left);
            System.out.println(n.val);
            inOrder(n.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int l, int r) {
        if (r < l) return null;

        int m = l + (r - l) / 2;
        TreeNode mNode = new TreeNode(nums[m]);
        mNode.left = helper(nums, l, m - 1);
        mNode.right = helper(nums, m + 1, r);
        return mNode;
    }
}
