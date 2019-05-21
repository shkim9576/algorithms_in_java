package dsalg.one.stack;

import java.util.Stack;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome o = new IsPalindrome();
        System.out.println(o.isPalindrome("aabbabXbabbaa"));
        System.out.println(o.isPalindrome("aaabbabXbabbaaa"));
        System.out.println(o.isPalindrome("aabbabXbabbaac"));
    }

    boolean isPalindrome(String s) {
        if (s == null) return true;

        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        return l >= r;
    }

    boolean isPalindromStack(String s) {
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (s.charAt(i) < s.length() && s.charAt(i) != 'X') {
            stack.push(s.charAt(i));
            i++;
        }
        i++;

        while (i < s.length()) {
            if (stack.isEmpty() || s.charAt(i) != stack.pop()) return false;
            i++;
        }

        return stack.isEmpty();
    }
}
