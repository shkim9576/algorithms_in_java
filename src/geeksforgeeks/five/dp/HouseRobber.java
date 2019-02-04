package geeksforgeeks.five.dp;

//https://leetcode.com/problems/house-robber
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber o = new HouseRobber();
        System.out.println(o.rob(new int[]{0,0,0,1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp = new int[n+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<=n; i++) {
            int cost = i == n ? 0 : nums[i];
            dp[i] = Math.max(dp[i-2] + cost, dp[i-1]);
        }

        return dp[n];
    }
}
