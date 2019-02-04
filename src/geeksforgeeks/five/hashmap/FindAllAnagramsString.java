package geeksforgeeks.five.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsString {

    public static void main(String[] args) {
        FindAllAnagramsString o = new FindAllAnagramsString();
        System.out.println(o.findAnagrams("cbaebabacd", "abc")); // 0, 6
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pCount = new int[128];
        for (char c : p.toCharArray()) pCount[c - 'a']++;

        int[] sCount = new int[128];
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) sCount[s.charAt(i) - 'a']++;
        if (Arrays.equals(sCount, pCount)) res.add(0);

        for (int i = 1; i + windowSize - 1 < s.length(); i++) {
            sCount[s.charAt(i - 1) - 'a']--;
            sCount[s.charAt(i - 1 + windowSize) - 'a']++;
            if (Arrays.equals(sCount, pCount)) res.add(i);
        }

        return res;
    }
}
