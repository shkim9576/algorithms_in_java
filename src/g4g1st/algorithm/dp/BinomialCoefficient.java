package g4g1st.algorithm.dp;

public class BinomialCoefficient {
    // https://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/

    public static void main(String[] args) {
        int n = 5, k = 2; // 10

        BinomialCoefficient ob = new BinomialCoefficient();
        System.out.println(ob.bc(n, k));
        System.out.println(ob.bcDP(n, k));
    }

    int bc(int n, int k) {
        if (k == 0 || n == k) return 1;
        return bc(n - 1, k - 1) + bc(n - 1, k);
    }

    int bcDP(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

}
