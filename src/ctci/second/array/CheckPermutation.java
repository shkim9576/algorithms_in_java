package ctci.second.array;

import java.util.Arrays;

public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation o = new CheckPermutation();
        System.out.println(o.isPermutation("acdeb", "abced"));
        System.out.println(o.isPermutationCount("acdeb", "abced"));
    }

    private boolean isPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    private boolean isPermutationCount(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[256];
        for (char c : s1.toCharArray()) count[c]++;
        for (char c : s2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }

}
