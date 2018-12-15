package geeksforgeeks.one.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    // https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        Trie trie = new Trie(root);
    }


    TrieNode root;

    public Trie(TrieNode root) {
        this.root = root;
    }

    static class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return (t != null && t.isLeaf);
    }

    public boolean startWith(String word) {
        return (searchNode(word) != null);
    }

    public TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;
            if (i == word.length() - 1) t.isLeaf = true;
        }
    }

}
