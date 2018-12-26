package leetcode.one.easy;

public class FindDifference {

    public static void main(String[] args) {
        FindDifference o = new FindDifference();
        System.out.println(o.findTheDifference("abcd", "abcde")); //e
    }

    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) if (count[c - 'a']-- == 0) return c;

        return 'x';
    }
}
