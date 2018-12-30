package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-distance-to-a-character/
public class ShortestDistanceToCharacter {

    public static void main(String[] args) {
        ShortestDistanceToCharacter o = new ShortestDistanceToCharacter();
        System.out.println(Arrays.toString(o.shortestToChar("loveleetcode", 'e'))); //[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
    }

    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;

        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }

        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }

        return res;
    }
}
