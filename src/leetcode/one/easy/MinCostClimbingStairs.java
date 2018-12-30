package leetcode.one.easy;

//https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs o = new MinCostClimbingStairs();
        System.out.println(o.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); //6
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int currCost = (i == cost.length) ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + currCost;
        }
        return dp[cost.length];
    }
}
