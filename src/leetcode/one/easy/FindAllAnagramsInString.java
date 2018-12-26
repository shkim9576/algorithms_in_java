package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        FindAllAnagramsInString o = new FindAllAnagramsInString();
        System.out.println(o.findAnagrams("cbaebabacd", "abc")); //0,6
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] count = new int[256];

        for (char c : p.toCharArray()) count[c]++;

        int left = 0, right = 0, numToMatch = p.length();

        while (right < s.length()) {
            if (count[s.charAt(right++)]-- >= 1) numToMatch--;
            if (numToMatch == 0) list.add(left);
            if (right - left == p.length() && count[s.charAt(left++)]++ >= 0) numToMatch++;
        }

        return list;
    }
}
