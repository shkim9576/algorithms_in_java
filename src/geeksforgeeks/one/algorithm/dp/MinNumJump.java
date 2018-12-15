package geeksforgeeks.one.algorithm.dp;

import java.util.Arrays;

public class MinNumJump {
    // https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
    // https://www.youtube.com/watch?v=cETfFsSTGJI

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; // 3

        MinNumJump ob = new MinNumJump();
        System.out.println(ob.minJump(A));
    }

    int minJump(int[] A) {
        int size = A.length;
        int[] dp = new int[size];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[size - 1];
    }

}
