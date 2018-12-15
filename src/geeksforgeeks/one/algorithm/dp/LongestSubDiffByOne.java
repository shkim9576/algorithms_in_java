package geeksforgeeks.one.algorithm.dp;

import java.util.Arrays;

public class LongestSubDiffByOne {
    // https://www.geeksforgeeks.org/longest-subsequence-such-that-difference-between-adjacents-is-one/

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 3, 2};  // 6

        LongestSubDiffByOne ob = new LongestSubDiffByOne();
        System.out.println(ob.getLongest(A));

        int[] B = {10, 9, 4, 5, 4, 8, 6}; // 3
        System.out.println(ob.getLongest(B));

        int[] C = {1, 2, 3, 2, 3, 7, 2, 1}; // 7
        System.out.println(ob.getLongest(C));
    }

    int getLongest(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int[] dp = new int[size];
        int max = 0;

        Arrays.fill(dp, 1);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] == A[j] + 1 || A[i] == A[j] - 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

}
