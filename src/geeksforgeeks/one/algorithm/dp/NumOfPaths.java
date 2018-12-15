package geeksforgeeks.one.algorithm.dp;

public class NumOfPaths {
    // https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
    public static void main(String[] args) {
        NumOfPaths ob = new NumOfPaths();
        System.out.println(ob.countAllPaths(3, 3)); // 6
    }

    int countAllPaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0) dp[r][c] = 1;
                else dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
