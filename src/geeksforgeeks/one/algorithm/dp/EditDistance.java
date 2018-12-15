package geeksforgeeks.one.algorithm.dp;

public class EditDistance {
    // https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        EditDistance ob = new EditDistance();
        System.out.println(ob.editDistance(str1, str2));  // 3
        System.out.println(ob.editDistanceDP(str1, str2));  // 3
    }

    int editDistanceDP(String str1, String str2) {

        int s1 = str1.length();
        int s2 = str2.length();

        int[][] dp = new int[s1 + 1][s2 + 1];

        for (int i = 0; i <= s1; i++) {
            for (int j = 0; j <= s2; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[s1][s2];
    }

    int editDistance(String str1, String str2) {

        int s1 = str1.length();
        int s2 = str2.length();

        if (s1 == 0) return s2;
        if (s2 == 0) return s1;

        // same chars. therefore no edit
        if (str1.charAt(s1 - 1) == str2.charAt(s2 - 1)) return editDistance(str1.substring(0, s1 - 1), str2.substring(0, s2 - 1));

        // each operations
        int add = editDistance(str1.substring(0, s1 - 1), str2.substring(0, s2));
        int remove = editDistance(str1.substring(0, s1), str2.substring(0, s2 - 1));
        int replace = editDistance(str1.substring(0, s1 - 1), str2.substring(0, s2 - 1));

        int min = Math.min(add, remove);
        min = Math.min(min, replace);

        return min + 1;
    }

}
