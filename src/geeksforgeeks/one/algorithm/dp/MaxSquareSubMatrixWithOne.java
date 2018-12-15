package geeksforgeeks.one.algorithm.dp;

import java.util.Arrays;

public class MaxSquareSubMatrixWithOne {
    // https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                     {1, 1, 0, 1, 0},
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};  // 3, 4, 3

        MaxSquareSubMatrixWithOne ob = new MaxSquareSubMatrixWithOne();
        int[] result = ob.maxSubSquareWithOnes(M);
        System.out.println(Arrays.toString(result));
    }

    int[] maxSubSquareWithOnes(int[][] M) {
        if (M == null || M.length == 0) return null;

        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            dp[i][0] = M[i][0];
        }

        for (int i = 0; i < C; i++) {
            dp[0][i] = M[0][i];
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (M[r][c] == 1) dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                else dp[r][c] = 0;
            }
        }

        int max = 0;
        int mr = 0;
        int mc = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (dp[r][c] > max) {
                    max = dp[r][c];
                    mr = r;
                    mc = c;
                }
            }
        }

        return new int[]{max, mr, mc};
    }

}
