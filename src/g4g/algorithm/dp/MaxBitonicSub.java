package g4g.algorithm.dp;

public class MaxBitonicSub {
    // https://www.geeksforgeeks.org/maximum-sum-bi-tonic-sub-sequence/

    public static void main(String[] args) {
        int[] A = {1, 15, 51, 45, 33, 100, 12, 18, 9}; // 194
        int[] B = {80, 60, 30, 40, 20, 10}; //210

        MaxBitonicSub ob = new MaxBitonicSub();
        System.out.println(ob.maxBitonic(A));
        System.out.println(ob.maxBitonic(B));
    }

    int maxBitonic(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int[] dp = new int[size];
        int[] dp2 = new int[size];

        for (int i = 0; i < size; i++) {
            dp[i] = A[i];
            dp2[i] = A[i];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = size - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + A[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) max = Math.max(dp[i] + dp2[i] - A[i], max);

        return max;
    }

}
