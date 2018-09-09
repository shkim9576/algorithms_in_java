package g4g1st.algorithm.dp;

public class LCS {
    // https://www.geeksforgeeks.org/longest-common-subsequence/

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        LCS ob = new LCS();
        System.out.println(ob.lcs(s1, s2));  // 4
    }

    int lcs(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];

        for (int i = 0; i <= s1; i++) {
            for (int j = 0; j <= s2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1][s2];
    }

}
