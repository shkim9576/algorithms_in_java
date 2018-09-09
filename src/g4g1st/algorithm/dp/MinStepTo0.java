package g4g1st.algorithm.dp;

import java.util.Arrays;

public class MinStepTo0 {
    // https://www.geeksforgeeks.org/minimum-steps-minimize-n-per-given-condition/

    public static void main(String[] args) {
        MinStepTo0 ob = new MinStepTo0();
        System.out.println(ob.countMinSteps(10)); // 3
        System.out.println(ob.countMinSteps(6)); // 2
    }

    int countMinSteps(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        return countMinSteps(n, dp);
    }

    int countMinSteps(int n, int[] dp) {
        if (n == 1) return 0;
        if (dp[n] != -1) return dp[n];

        int res = countMinSteps(n - 1, dp);
        if (n % 2 == 0) res = Math.min(res, countMinSteps(n / 2, dp));
        if (n % 3 == 0) res = Math.min(res, countMinSteps(n / 3, dp));
        dp[n] = res + 1;

        return dp[n];
    }
}
