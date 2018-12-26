package leetcode.one.easy;

//https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumberHigherLower {

    public static void main(String[] args) {
        GuessNumberHigherLower o = new GuessNumberHigherLower();
        System.out.println(o.guessNumber(10));
    }

    public int guessNumber(int n) {
        return helper(1, n);
    }

    public int helper(int l, int r) {
        int m = l + (r - l) / 2;

        int guessResult = guessNumberImpl(m);
        if (guessResult == 0) return m;
        if (guessResult == 1) return helper(l, m - 1);
        return helper(m + 1, r);
    }

    public int guessNumberImpl(int n) {
        if (n == 6) return 0;
        return n < 6 ? -1 : 1;
    }

}
