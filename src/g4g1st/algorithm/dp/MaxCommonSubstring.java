package g4g1st.algorithm.dp;

public class MaxCommonSubstring {

    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        MaxCommonSubstring ob = new MaxCommonSubstring();
        System.out.println(ob.getMaxSubstring(X, Y));  // 10
    }

    int getMaxSubstring(String str1, String str2) {
        if (str1 == null || str1.length() == 0) return 0;
        if (str2 == null || str2.length() == 0) return 0;

        int s1 = str1.length();
        int s2 = str2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 0; i < s1; i++) dp[i][0] = 0;
        for (int j = 0; j < s2; j++) dp[0][j] = 0;

        int max = 0;
        for (int i = 1; i < s1; i++) {
            for (int j = 1; j < s2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

}
