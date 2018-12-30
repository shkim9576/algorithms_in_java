package leetcode.one.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/most-common-word/
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord o = new MostCommonWord();
        //System.out.println(o.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"})); //ball
        System.out.println(o.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"})); //ball
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] splits = paragraph.toLowerCase().split("\\!|\\?|\\'|\\,|\\;|\\.| ");
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned) bannedSet.add(s);

        Map<String, Integer> count = new HashMap<>();
        for (String s : splits) {
            if (!bannedSet.contains(s) && !"".equals(s)) count.put(s, count.getOrDefault(s, 0) + 1);
        }

        String result = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        return result;
    }
}
