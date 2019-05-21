package dsalg.two.tree;

public class Catalan {

    public static void main(String[] args) {
        Catalan o = new Catalan();
        System.out.println(o.catalan(3));
    }

    int catalan(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
