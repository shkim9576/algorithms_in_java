package programcreek.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ShortestWordDistance2 {
    // https://www.programcreek.com/2014/07/leetcode-shortest-word-distance-ii-java/

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";  //  3
        String word3 = "makes", word4 = "coding"; // 1

        ShortestWordDistance2 ob = new ShortestWordDistance2();
        System.out.println(ob.minDistnce(words, word1, word2));
        System.out.println(ob.minDistnce(words, word3, word4));

    }

    int minDistnce(String[] words, String w1, String w2) {
        if (words == null || words.length < 2) return -1;

        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w1) && map.containsKey(w2)) {
                min = Math.min(min, i - map.get(w2));
            } else if (words[i].equals(w2) && map.containsKey(w1)) {
                min = Math.min(min, i - map.get(w1));
            }
            map.put(words[i], i);
        }

        return min;
    }

}
