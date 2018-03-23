package g4g.algorithm.dp;

public class CuttingRod {
    // https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/

    public static void main(String[] args) {
        int P[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20}; // 22

        CuttingRod ob = new CuttingRod();
        System.out.println(ob.maxValue(P));
    }

    int maxValue(int[] P) {

        int n = P.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, P[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
