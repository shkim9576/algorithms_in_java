package leetcode.one.easy;

//https://leetcode.com/problems/longest-continuous-increasing-subsequence/submissions/
public class LongestContinuousSubsequence {

    public static void main(String[] args) {
        LongestContinuousSubsequence o = new LongestContinuousSubsequence();
        System.out.println(o.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7})); //3
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }

        return max;
    }
}
