package geeksforgeeks.five.trie;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/replace-words/
public class ReplaceWord {

    public static void main(String[] args) {
        ReplaceWord o = new ReplaceWord();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String result = o.replaceWords(dict, "the cattle was rattled by the battery");
        System.out.println(result);
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        buildTrie(root, dict);

        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split("\\s+")) {
            if (sb.length() != 0) sb.append(" ");
            String word = findRootWord(root, s);
            sb.append(word);
        }
        return sb.toString();
    }

    String findRootWord(TrieNode root, String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            curr = curr.children[c - 'a'];
            if (curr == null) return s;
            if (curr.word != null) return curr.word;
        }
        return s;
    }

    void buildTrie(TrieNode root, List<String> dict) {
        for (String s : dict) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
            curr.word = s;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
