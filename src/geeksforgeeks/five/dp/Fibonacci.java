package geeksforgeeks.five.dp;

//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(9)); //34
        System.out.println(fibonacciOptimized(9)); //34
    }

    static int fibonacciOptimized(int n) {
        if (n <= 1) return n;

        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    static int fibonacci(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
