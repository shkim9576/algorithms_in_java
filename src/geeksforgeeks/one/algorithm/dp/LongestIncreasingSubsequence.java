package geeksforgeeks.one.algorithm.dp;

public class LongestIncreasingSubsequence {
    // https://www.geeksforgeeks.org/longest-increasing-subsequence/

    public static void main(String[] args) {
        int A[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; // 5

        LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
        System.out.println(ob.lis(A));
    }

    int lis(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int[] dp = new int[size];

        for (int i=0; i<size; i++) dp[i] = 1;

        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (A[i] > A[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j]+1;
            }
        }

        int max = 1;
        for (int i=0; i<size; i++) {
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }

}
