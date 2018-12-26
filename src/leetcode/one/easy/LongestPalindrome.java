package leetcode.one.easy;

//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome o = new LongestPalindrome();
        System.out.println(o.longestPalindrome("abccccdd")); //7
    }

    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) count[c]++;

        boolean hasOdd = false;
        int sum = 0;

        for (int i = 0; i < 128; i++) {
            if (count[i] % 2 == 0) sum += count[i];
            else {
                sum += count[i] - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? sum + 1 : sum;
    }
}
