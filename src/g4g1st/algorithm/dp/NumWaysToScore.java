package g4g1st.algorithm.dp;

public class NumWaysToScore {
    // https://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/

    public static void main(String[] args) {
        NumWaysToScore ob = new NumWaysToScore();
        System.out.println(ob.numWays(20)); // 4
        System.out.println(ob.numWays(13)); // 2
    }

    int numWays(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=3; i<=n; i++) dp[i] += dp[i-3];
        for (int i=5; i<=n; i++) dp[i] += dp[i-5];
        for (int i=10; i<=n; i++) dp[i] += dp[i-10];

        return dp[n];
    }

}
