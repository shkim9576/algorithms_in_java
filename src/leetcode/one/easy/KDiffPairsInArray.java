package leetcode.one.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class KDiffPairsInArray {

    public static void main(String[] args) {
        KDiffPairsInArray o = new KDiffPairsInArray();
        System.out.println(o.findPairs(new int[]{3, 1, 4, 1, 5}, 2)); //2
    }

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) count.put(n, count.getOrDefault(n, 0) + 1);

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) result++;
            } else {
                if (count.containsKey(entry.getKey() + k)) result++;
            }
        }

        return result;
    }
}
