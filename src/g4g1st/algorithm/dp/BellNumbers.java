package g4g1st.algorithm.dp;

public class BellNumbers {
    // https://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/

    public static void main(String[] args) {
        BellNumbers ob = new BellNumbers();

        for (int n = 0; n <= 5; n++)
            System.out.println("Bell Number " + n + " is " + ob.bellNumber(n));
    }

    int bellNumber(int n) {
        int[][] bell = new int[n + 1][n + 1];
        bell[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Explicitly fill for j = 0
            bell[i][0] = bell[i - 1][i - 1];

            // Fill for remaining values of j
            for (int j = 1; j <= i; j++)
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
        }

        return bell[n][0];
    }
}
