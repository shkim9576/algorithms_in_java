package g4g1st.algorithm.dp;

public class Fibonacci {
    // https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

    public static void main(String[] args) {
        Fibonacci ob = new Fibonacci();
        System.out.println(ob.fib(9)); //34
    }

    int fib(int n) {
        if (n <=1) return n;

        int pp=0;
        int p=1;
        int curr = 0;
        for (int i=2; i<=n; i++) {
            curr = p + pp;
            pp = p;
            p = curr;
        }

        return curr;
    }

}
