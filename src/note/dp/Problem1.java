package note.dp;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        System.out.println(p.getUglyNumber(150)); // 5832
    }

    int getUglyNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int value2 = 2;
        int value3 = 3;
        int value5 = 5;
        int nextUglyNumber = 1;

        for (int i = 1; i < n; i++) {
            nextUglyNumber = Math.min(Math.min(value2, value3), value5);
            dp[i] = nextUglyNumber;

            if (nextUglyNumber == value2) value2 = dp[++index2] * 2;
            if (nextUglyNumber == value3) value3 = dp[++index3] * 3;
            if (nextUglyNumber == value5) value5 = dp[++index5] * 5;
        }

        return nextUglyNumber;
    }
}
