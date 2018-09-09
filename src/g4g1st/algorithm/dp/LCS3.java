package g4g1st.algorithm.dp;

public class LCS3 {
    // https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/

    public static void main(String[] args) {
        String X = "AGGT12";
        String Y = "12TXAYB";
        String Z = "12XBA";

        LCS3 ob = new LCS3();
        System.out.println(ob.lcs3(X, Y, Z)); // 2
    }

    int lcs3(String str1, String str2, String str3) {
        if (str1 == null || str2 == null || str3 == null) return 0;
        if (str1.length() == 0 || str2.length() == 0 || str3.length() == 0) return 0;

        int s1 = str1.length();
        int s2 = str2.length();
        int s3 = str3.length();

        int[][][] dp = new int[s1 + 1][s2 + 1][s3 + 1];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {

                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = max(dp[i - 1][j][k],
                                          dp[i][j - 1][k],
                                          dp[i][j][k - 1]);
                    }
                }
            }
        }

        return dp[s1][s2][s3];
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}
