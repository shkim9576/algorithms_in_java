package geeksforgeeks.one.algorithm.dp;

public class CoinChange {
    // https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};

        CoinChange ob = new CoinChange();
        System.out.println(ob.countWays(arr, 4));
    }

    long countWays(int[] A, int n) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 0; i < size; i++) {
            for (int j = A[i]; j <= n; j++) {
                dp[j] += dp[j - A[i]];
            }
        }

        return dp[n];
    }

}
