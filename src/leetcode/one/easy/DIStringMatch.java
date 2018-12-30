package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/di-string-match/
public class DIStringMatch {

    public static void main(String[] args) {
        DIStringMatch o = new DIStringMatch();
        System.out.println(Arrays.toString(o.diStringMatch("IDID"))); //[0, 4, 1, 3, 2]
    }

    public int[] diStringMatch(String S) {
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];

        for (int i = 0; i < n; ++i)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;

        res[n] = left;
        return res;
    }
}
