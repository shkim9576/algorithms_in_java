package leetcode.one.easy;

//https://leetcode.com/problems/reverse-only-letters/
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        ReverseOnlyLetters o = new ReverseOnlyLetters();
        System.out.println(o.reverseOnlyLetters("a-bC-dEf-ghIj")); //j-Ih-gfE-dCba
    }

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l < r) {
            while (l < r && !Character.isLetter(chars[r])) r--;
            while (l < r && !Character.isLetter(chars[l])) l++;
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }

        return new String(chars);
    }
}
