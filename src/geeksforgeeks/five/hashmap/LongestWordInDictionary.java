package geeksforgeeks.five.hashmap;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/longest-word-in-dictionary/
public class LongestWordInDictionary {

    public static void main(String[] args) {
        LongestWordInDictionary o = new LongestWordInDictionary();
        System.out.println(o.longestWord(new String[]{"w","wo","wor","worl","world"}));
    }


    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                set.add(w);
                res = w.length() > res.length() ? w : res;
            }
        }

        return res;
    }
}
