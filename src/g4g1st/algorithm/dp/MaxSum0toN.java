package g4g1st.algorithm.dp;

public class MaxSum0toN {
    // https://www.geeksforgeeks.org/maximum-path-sum-starting-cell-0-th-row-ending-cell-n-1-th-row/

    public static void main(String[] args) {
        int[][] M = {{4, 2, 3, 4},
                     {2, 9, 1, 10},
                     {15, 1, 3, 0},
                     {16, 92, 41, 44}};  // 120

        MaxSum0toN ob = new MaxSum0toN();
        System.out.println(ob.maxSum(M));
    }

    int maxSum(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R][C + 2];

        for (int i = 0; i < R; i++) dp[0][i + 1] = M[0][i];

        int max = 0;
        for (int r = 1; r < R; r++) {
            for (int c = 1; c <= C; c++) {
                dp[r][c] = max(dp[r - 1][c], dp[r - 1][c - 1], dp[r - 1][c + 1]) + M[r][c - 1];
                max = Math.max(max, dp[r][c]);
            }
        }

        return max;
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}
