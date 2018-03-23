package g4g.algorithm.dp;

public class GoldMine {
    // https://www.geeksforgeeks.org/gold-mine-problem/

    public static void main(String[] args) {
        int[][] M = {{1, 3, 1, 5},
                     {2, 2, 4, 1},
                     {5, 0, 2, 3},
                     {0, 6, 1, 2}};  // 16

        GoldMine ob = new GoldMine();
        System.out.println(ob.goldMine(M));
    }

    int goldMine(int[][] M) {
        if (M == null || M.length == 0) return 0;

        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R + 2][C];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) dp[i + 1][0] = M[i][0];

        for (int c = 1; c < C; c++) {
            for (int r = 1; r < R; r++) {
                dp[r][c] = max(dp[r + 1][c - 1], dp[r - 1][c - 1], dp[r][c - 1]) + M[r][c];
                max = Math.max(max, dp[r][c]);
            }
        }

        print(dp);
        return max;
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
