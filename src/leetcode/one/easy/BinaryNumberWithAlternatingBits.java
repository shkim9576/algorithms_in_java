package leetcode.one.easy;

//https://leetcode.com/problems/binary-number-with-alternating-bits/submissions/
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits o = new BinaryNumberWithAlternatingBits();
        System.out.println(o.hasAlternatingBits(5)); //true
    }

    public boolean hasAlternatingBits(int n) {
        int prev = -1;

        while (n > 0) {
            int isSet = (n & 1);
            if (isSet == prev) return false;
            prev = isSet;
            n = n >> 1;
        }

        return true;
    }
}
