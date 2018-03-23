package g4g.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class MinCostToFillBag {
    // https://www.geeksforgeeks.org/minimum-cost-to-fill-given-weight-in-a-bag/

    public static void main(String[] args) {
        int cost[] = {1, 2, 3, 4, 5}, W = 5;

        MinCostToFillBag ob = new MinCostToFillBag();
        System.out.println(ob.minCost(cost, W));
    }

    int minCost(int[] cost, int W) {
        List<Integer> val = new ArrayList<>();
        List<Integer> weight = new ArrayList<>();

        int n = cost.length;
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                val.add(cost[i]);
                weight.add(i + 1);
                size++;
            }
        }

        n = size;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= W; i++) dp[0][i] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) dp[i][0] = dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight.get(i - 1) > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - weight.get(i - 1)] + val.get(i - 1));
            }
        }

        return dp[n][W] == Integer.MAX_VALUE ? -1 : dp[n][W];
    }
}
