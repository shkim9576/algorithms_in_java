package leetcode.one.easy;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger o = new ReverseInteger();
        System.out.println(o.reverse(123));
        System.out.println(o.reverse(-123));
        System.out.println(o.reverse(56));
        System.out.println(o.reverse(-56));
        System.out.println(o.reverse(0));
    }

    public int reverse(int x) {
        int result = 0;

        while(x != 0) {
            int lastDigit = x % 10;

            if (((result * 10 + lastDigit - lastDigit) / 10) != result) return 0;

            result = result * 10 + lastDigit;
            x /= 10;
        }

        return result;
    }

}
