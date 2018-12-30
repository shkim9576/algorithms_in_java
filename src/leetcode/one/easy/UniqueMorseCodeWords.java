package leetcode.one.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-morse-code-words/
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        UniqueMorseCodeWords o = new UniqueMorseCodeWords();
        System.out.println(o.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"})); //2
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(codes[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
