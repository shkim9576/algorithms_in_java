package ctci.first.array;

import java.util.Arrays;

public class IsPermutation {
    public static void main(String[] args) {
        String s1 = "abceexx";
        String s2 = "aceebxx";
        String s3 = "abceexxa";

        IsPermutation ob = new IsPermutation();
        System.out.println(ob.isPermutation(s1, s2)); // true
        System.out.println(ob.isPermutation(s1, s3)); // false

        System.out.println(ob.isPermutationCount(s1, s2)); // true
        System.out.println(ob.isPermutationCount(s1, s3)); // false
    }

    boolean isPermutationCount(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[256];
        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }

    boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String sorted1 = sort(s1);
        String sorted2 = sort(s2);
        return sorted1.equals(sorted2);
    }

    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
