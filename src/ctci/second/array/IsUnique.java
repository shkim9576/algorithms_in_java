package ctci.second.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static void main(String[] args) {
        IsUnique o = new IsUnique();

        System.out.println(o.isUniqueSet("abcdefg"));  //true
        System.out.println(o.isUniqueSet("abcdefgb"));  //false

        System.out.println(o.isUniqueArray("abcdefg"));  //true
        System.out.println(o.isUniqueArray("abcdefgb"));  //false

        System.out.println(o.isUniqueBit("abcdefg"));  //true
        System.out.println(o.isUniqueBit("abcdefgb"));  //false

        System.out.println(o.isUniqueSorting("abcdefg"));  //true
        System.out.println(o.isUniqueSorting("abcdefgb"));  //false
    }

    private boolean isUniqueSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) return false;
        }
        return true;
    }

    private boolean isUniqueArray(String s) {
        boolean[] chars = new boolean[256];
        for (char c : s.toCharArray()) {
            if (chars[c]) return false;
            chars[c] = true;
        }
        return true;
    }

    private boolean isUniqueBit(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            int charIndex = c - 'a';
            if (((1 << charIndex) & mask) > 0) return false;
            mask |= (1 << charIndex);
        }
        return true;
    }

    private boolean isUniqueSorting(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (Arrays.binarySearch(chars, i + 1, chars.length, chars[i]) >= 0) return false;
        }
        return true;
    }
}
