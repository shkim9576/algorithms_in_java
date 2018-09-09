package ctci.dp;

import java.util.Arrays;

public class TrippleStep {

    public static void main(String[] args) {
        TrippleStep ob = new TrippleStep();

        int n = 7;
        System.out.println(ob.countWays(n));

        int[] m = new int[n+1];
        Arrays.fill(m, -1);
        System.out.println(ob.countWayTopDown(n, m));
    }

    int countWays(int n) {
        if (n <= 0) return 0;

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for (int step = 3; step <= n; step++) {
            memo[step] = memo[step-1] + memo[step-2] + memo[step-3];
        }

        return memo[n];
    }

    int countWayTopDown(int n, int[] m) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (m[n] == -1) {
            m[n] = countWayTopDown(n-1, m) + countWayTopDown(n-2, m) + countWayTopDown(n-3, m);
        }

        return m[n];
    }

}
