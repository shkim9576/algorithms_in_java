package g4g1st.algorithm.dp;

public class Break3Sum {
    // https://www.geeksforgeeks.org/recursively-break-number-3-parts-get-maximum-sum/

    public static void main(String[] args) {
        Break3Sum ob = new Break3Sum();
        System.out.println(ob.breakSum(24)); //27
    }

    int breakSum(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) dp[i] = Math.max(dp[i/2] + dp[i/3] + dp[i/4], i);

        return dp[n];
    }

}
