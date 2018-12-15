package blog.hashtable;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 p = new Problem2();
        System.out.println(p.twoStrings("hello", "hi")); // yes
        System.out.println(p.twoStrings("abcdefg", "xyz")); // no
    }

    static String twoStrings(String s1, String s2) {
        if (s1 == null || s2 == null) return "NO";

        boolean[] seen = new boolean[26];

        for (char c : s1.toCharArray()) {
            seen[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (seen[c - 'a']) return "YES";
        }

        return "NO";
    }
}
