package g4g.algorithm.dp;

public class MaxSumIncSub {
    // https://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/

    public static void main(String[] args) {
        int A[] = new int[]{1, 101, 2, 3, 100, 4, 5}; // 106

        MaxSumIncSub ob = new MaxSumIncSub();
        System.out.println(ob.maxSumIncSub(A));
    }

    int maxSumIncSub(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int[] dp = new int[size];

        dp[0] = A[0];

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < size; i++) {
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }

}
