package leetcode.one.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        LongestHarmoniousSubsequence o = new LongestHarmoniousSubsequence();
        System.out.println(o.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7})); //5
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        int result = 0;
        for (int i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                result = Math.max(result, map.get(i) + map.get(i + 1));
            }
        }

        return result;
    }
}
