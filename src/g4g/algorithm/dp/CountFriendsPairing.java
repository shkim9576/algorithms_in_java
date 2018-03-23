package g4g.algorithm.dp;

public class CountFriendsPairing {
    // https://www.geeksforgeeks.org/friends-pairing-problem/

    public static void main(String[] args) {
        CountFriendsPairing ob = new CountFriendsPairing();
        System.out.println(ob.countFriendsPairing(4));  // 10
    }

    int countFriendsPairing(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) dp[i] = i;
                // The nth person can pairs up in (n - 1) ways.
                // so there is (n - 1) multiplied in equation.
                // Also the remaining n - 2 persons can further pair up in f(n - 2) ways.
            else dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

}
