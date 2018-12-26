package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram o = new ValidAnagram();
        System.out.println(o.isAnagram("anagram", "nagaram")); // true
    }

    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a']++;
        for(char c : t.toCharArray()) count[c - 'a']--;

        for(int n : count) if(n != 0) return false;
        return true;
    }
}
