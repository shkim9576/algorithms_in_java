package leetcode.one.easy;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome2 {

    public static void main(String[] args) {
        ValidPalindrome2 o = new ValidPalindrome2();
        System.out.println(o.validPalindrome("abca")); //true
    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isValidPalindrome(s, l + 1, r) || isValidPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isValidPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
