package blog.dp;

public class Problem4 {
    public static void main(String[] args) {
        Problem4 p = new Problem4();
        System.out.println(p.binomialCoefficient(5, 2));
        System.out.println(p.binomialCoefficientDP(5, 2));
    }

    int binomialCoefficient(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    int factorial(int x) {
        if (x <= 1) return x;
        return x * factorial(x - 1);
    }

    int binomialCoefficientDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || i == j) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

}
