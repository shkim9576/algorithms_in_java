package leetcode.one.easy;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class VerifyingAlienDictionary {

    public static void main(String[] args) {
        VerifyingAlienDictionary o = new VerifyingAlienDictionary();
        System.out.println(o.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); //true
    }

    public boolean isAlienSorted(String[] words, String order) {

        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (isSorted(words[i], words[i + 1], map) > 0) return false;
        }

        return true;
    }

    private int isSorted(String before, String after, int[] mapping) {
        int n = before.length(), m = after.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            cmp = mapping[before.charAt(i) - 'a'] - mapping[after.charAt(j) - 'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }
}
