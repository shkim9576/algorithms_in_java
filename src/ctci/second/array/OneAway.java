package ctci.second.array;

public class OneAway {

    public static void main(String[] args) {
        OneAway o = new OneAway();

        System.out.println(o.isOneAway("pale", "ple")); //t
        System.out.println(o.isOneAway("pales", "pale")); //t
        System.out.println(o.isOneAway("pale", "bale")); //t
        System.out.println(o.isOneAway("pale", "bae")); //f

        System.out.println(o.isOneAwayDP("pale", "ple")); //t
        System.out.println(o.isOneAwayDP("pales", "pale")); //t
        System.out.println(o.isOneAwayDP("pale", "bale")); //t
        System.out.println(o.isOneAwayDP("pale", "bae")); //f
    }

    private boolean isOneAway(String s1, String s2) {
        if (s1.length() == s2.length()) return isOneEdit(s1, s2);
        if (s1.length() + 1 == s2.length()) return isOneInsertion(s1, s2);
        if (s1.length() == s2.length() + 1) return isOneInsertion(s2, s1);
        return false;
    }

    private boolean isOneEdit(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) return false;
                found = true;
            }
        }
        return true;
    }

    private boolean isOneInsertion(String longer, String shorter) {
        int l = 0, s = 0;
        boolean found = false;
        while (l < longer.length() && s < shorter.length()) {
            if (longer.charAt(l) != shorter.charAt(s)) {
                if (found) return false;
                found = true;
                s++;
            }
            s++;
            l++;
        }
        return true;
    }

    private boolean isOneAwayDP(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int r = 1; r <= l1; r++) {
            for (int c = 1; c <= l2; c++) {
                if (s1.charAt(r - 1) == s2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                }
            }
        }

        return dp[l1][l2] == 1;
    }
}
