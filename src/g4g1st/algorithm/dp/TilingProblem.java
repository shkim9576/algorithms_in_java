package g4g1st.algorithm.dp;

public class TilingProblem {
    // https://www.geeksforgeeks.org/tiling-problem/

    public static void main(String[] args) {
        TilingProblem ob = new TilingProblem();
        System.out.println(ob.count(4)); // 5
    }

    int count(int n) {
        if (n <= 0) return 0;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
