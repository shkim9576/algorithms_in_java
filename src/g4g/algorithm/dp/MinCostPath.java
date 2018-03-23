package g4g.algorithm.dp;

public class MinCostPath {
    // https://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};

        MinCostPath ob = new MinCostPath();
        System.out.println(ob.minCost(cost));
    }

    int minCost(int[][] M) {
        if (M == null || M.length == 0) return -1;

        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R][C];

        dp[0][0] = M[0][0];
        for (int i = 1; i < C; i++) dp[0][i] = dp[0][i - 1] + M[0][i];
        for (int i = 1; i < R; i++) dp[i][0] = dp[i - 1][0] + M[i][0];

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + M[r][c];
            }
        }

        return dp[R - 1][C - 1];
    }

}
