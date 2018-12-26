package leetcode.one.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/keyboard-row/
public class KeyboardRow {
    public static void main(String[] args) {
        KeyboardRow o = new KeyboardRow();
        System.out.println(Arrays.toString(o.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}))); //[Alaska, Dad]
    }

    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        List<String> result = new ArrayList<>();

        for (String w : words) {
            int currRow = 0;

            for (int i = 0; i < 3; i++) {
                if (rows[i].indexOf(w.charAt(0)) != -1) {
                    currRow = i;
                    break;
                }
            }

            boolean found = true;

            for (char c : w.toCharArray()) {
                if (rows[currRow].indexOf(c) == -1) {
                    found = false;
                    break;
                }
            }

            if (found) result.add(w);
        }

        return result.toArray(new String[0]);
    }
}
