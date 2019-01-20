package geeksforgeeks.five.searching;

import java.util.*;

public class WordSearch2 {

    public static void main(String[] args) {
        WordSearch2 o = new WordSearch2();

        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(o.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        HashSet<String> result = new HashSet<>();

        Trie trie = new Trie();
        for (String w : words) trie.insert(w);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs("", board, r, c, trie, visited, result);
            }
        }
        return new ArrayList<>(result);
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    void dfs(String s, char[][] board, int x, int y, Trie trie, boolean[][] visited, HashSet<String> result) {
        if (!isSafe(x, y, board)) return;
        if (visited[x][y]) return;

        s += board[x][y];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) result.add(s);

        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            dfs(s, board, x + dx[i], y + dy[i], trie, visited, result);
        }
        visited[x][y] = false;
    }

    boolean isSafe(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    class Trie {

        TrieNode root = new TrieNode();

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isLeaf = false;
        }

        public void insert(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }

            curr.isLeaf = true;
        }

        public boolean startsWith(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return curr != null;
        }

        public boolean search(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return curr != null && curr.isLeaf;
        }
    }

}
