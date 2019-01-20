package geeksforgeeks.five.dp;

//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChange {

    // 4
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(count(arr, 4));
    }

    static int count(int[] A, int N) {
        int m = A.length;
        int[] dp = new int[N + 1];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = A[i]; j <= N; j++) {
                dp[j] += dp[j - A[i]];
            }
        }

        return dp[N];
    }
}
