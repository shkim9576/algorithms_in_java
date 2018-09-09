package g4g1st.algorithm.dp;

public class MaxSubNoThreeCons {
    // https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/

    public static void main(String[] args) {
        int A[] = {100, 1000, 100, 1000, 1}; // 2101

        MaxSubNoThreeCons ob = new MaxSubNoThreeCons();
        System.out.println(ob.maxSumNo3Con(A));
    }

    int maxSumNo3Con(int[] A) {

        int size = A.length;
        int[] dp = new int[size];

        dp[0] = A[0];
        dp[1] = A[0] + A[1];
        dp[2] = Math.max(dp[1], A[1] + A[2]);

        for (int i = 3; i < size; i++) {
            dp[i] = max(dp[i - 1],
                        dp[i - 2] + A[i],
                        A[i] + A[i - 1] + dp[i - 3]);
        }

        return dp[size - 1];
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
