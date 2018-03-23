package g4g.algorithm.dp;

import java.util.Arrays;

public class MaxSumPairK {
    // https://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/

    public static void main(String[] args) {
        MaxSumPairK ob = new MaxSumPairK();

        int[] A = {3, 5, 10, 15, 17, 12, 9};
        System.out.println(ob.maxSumPair(A, 4));  // 62
    }

    int maxSumPair(int[] A, int k) {
        if (A == null || A.length == 0) return 0;

        Arrays.sort(A);
        int size = A.length;
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = A[0] + A[1];

        for (int i = 2; i < size; i++) {
            if (A[i] - A[i - 1] < k) dp[i] = Math.max(dp[i - 2] + A[i] + A[i - 1], dp[i - 1]);
            else dp[i] = dp[i - 1];
        }

        return dp[size - 1];
    }

}
