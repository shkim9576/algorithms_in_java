package geeksforgeeks.five.dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/gold-mine-problem/
public class GoldMine {

    // 16
    public static void main(String arg[]) {
        int gold[][] = {{1, 3, 1, 5},
                        {2, 2, 4, 1},
                        {5, 0, 2, 3},
                        {0, 6, 1, 2}};

        System.out.print(getMaxGold(gold));
    }

    static int getMaxGold(int[][] M) {
        int numR = M.length;
        int numC = M[0].length;
        int[][] dp = new int[numR][numC];

        for (int r = 0; r < numR; r++) dp[r][0] = M[r][0];

        // Important: have row inner loop and col outer loop. otherwise, result will be wrong.
        for (int c = 1; c < numC; c++) {
            for (int r = 0; r < numR; r++) {
                if (r == 0) {
                    dp[0][c] = Math.max(dp[0][c - 1], dp[1][c - 1]) + M[0][c];
                } else if (r == numR - 1) {
                    dp[numR - 1][c] = Math.max(dp[numR - 1][c - 1], dp[numR - 2][c - 1]) + M[numR - 1][c];
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c - 1], Math.max(dp[r][c - 1], dp[r + 1][c - 1])) + M[r][c];
                }
            }
        }

        int max = 0;
        for (int r = 0; r < numR; r++) {
            max = Math.max(max, dp[r][numC - 1]);
        }

        System.out.println(Arrays.deepToString(dp));

        return max;
    }

}
