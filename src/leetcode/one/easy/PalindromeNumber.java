package leetcode.one.easy;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber o = new PalindromeNumber();
        System.out.println(o.isPalindrome(121)); //true
        System.out.println(o.isPalindrome(122)); //false
        System.out.println(o.isPalindrome(-121)); //false
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int org = x;

        while(x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == org;
    }
}
