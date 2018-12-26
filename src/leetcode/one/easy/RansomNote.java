package leetcode.one.easy;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {

    public static void main(String[] args) {
        RansomNote o = new RansomNote();
        System.out.println(o.canConstruct("aa", "ab")); //false
        System.out.println(o.canConstruct("aa", "aab")); //true
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) count[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a']-- <= 0) return false;
        }

        return true;
    }
}
