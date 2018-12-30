package leetcode.one.easy;

import java.util.*;

//https://leetcode.com/problems/uncommon-words-from-two-sentences/
public class UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences o = new UncommonWordsFromTwoSentences();
        System.out.println(Arrays.toString(o.uncommonFromSentences("this apple is sweet", "this apple is sour"))); //[sweet, sour]
    }

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();

        for (String s : (A + " " + B).split(" ")) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String s : count.keySet()) {
            if (count.get(s) == 1) result.add(s);
        }

        return result.toArray(new String[0]);
    }
}
