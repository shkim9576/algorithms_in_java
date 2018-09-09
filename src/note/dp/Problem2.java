package note.dp;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        System.out.println(p.fibonacci(2)); // 1
        System.out.println(p.fibonacci(9)); // 34
    }

    int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n < 2) {
            return n;
        }

        int pp = 0;
        int p = 1;
        int curr = 0;

        for (int i=2; i<=n; i++) {
            curr = p + pp;
            pp = p;
            p = curr;
        }

        return curr;
    }
}
