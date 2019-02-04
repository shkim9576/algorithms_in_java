package leetcode.one.easy;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome o = new ValidPalindrome();
        System.out.println(o.isPalindrome("A man, a plan, a canal: Panama")); //true
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        s = s.trim().toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l <= r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l <= r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (l > r) return true;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
