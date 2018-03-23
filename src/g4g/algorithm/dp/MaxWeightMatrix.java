package g4g.algorithm.dp;

public class MaxWeightMatrix {
    // https://www.geeksforgeeks.org/maximum-weight-path-ending-element-last-row-matrix/

    public static void main(String[] args) {
        int mat[][] = {{4, 1, 5, 6, 1},
                       {2, 9, 2, 11, 10},
                       {15, 1, 3, 15, 2},
                       {16, 92, 41, 4, 3},
                       {8, 142, 6, 4, 8}
        };

        MaxWeightMatrix ob = new MaxWeightMatrix();
        System.out.println(ob.maxCost(mat)); // 255
    }

    int maxCost(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R][C];

        for (int c = 0; c < C; c++) dp[0][c] = M[0][c];
        for (int r = 1; r < R; r++) dp[r][0] = dp[r - 1][0] + M[r][0];

        int max = 0;
        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                dp[r][c] = Math.max(dp[r - 1][c], dp[r - 1][c - 1]) + M[r][c];
                max = Math.max(max, dp[r][c]);
            }
        }
        return max;
    }
}
