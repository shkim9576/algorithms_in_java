package blog.array;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 p = new Problem1();

        System.out.println(p.hasDuplicateCharBitVector("a")); // true
        System.out.println(p.hasDuplicateCharBitVector("abcdezyx")); // true
        System.out.println(p.hasDuplicateCharBitVector("abcdezyxc")); // false
    }

    boolean hasDuplicateChar(String s) {

        if (s == null || s.length() < 2) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        boolean[] seen = new boolean[128];

        for (char c : s.toCharArray()) {
            if (seen[c]) {
                return false;
            } else {
                seen[c] = true;
            }
        }

        return true;
    }

    boolean hasDuplicateCharSorted(String s) {

        if (s == null || s.length() < 2) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    boolean hasDuplicateCharBitVector(String s) {


        if (s == null || s.length() < 2) {
            return true;
        }

        if (s.length() > 128) {
            return false;
        }

        int bits = 0;

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if ((bits & (1<<index)) > 0) {
                return false;
            } else {
                bits |= (1<<index);
            }
        }

        return true;
    }


}
