package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {

    public static void main(String[] args) {
        LetterCasePermutation o = new LetterCasePermutation();
        System.out.println(o.letterCasePermutation("a1b2")); //[A1B2, A1b2, a1B2, a1b2]
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        dfs(result, S.toCharArray(), 0);
        return result;
    }

    public void dfs(List<String> result, char[] chars, int pos) {
        if (pos == chars.length) result.add(new String(chars));
        else {
            if (Character.isLetter(chars[pos])) {
                chars[pos] = Character.toUpperCase(chars[pos]);
                dfs(result, chars, pos + 1);
                chars[pos] = Character.toLowerCase(chars[pos]);
            }
            dfs(result, chars, pos + 1);
        }
    }
}
