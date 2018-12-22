package leetcode.one.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        TwoSum o = new TwoSum();

        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(o.twoSum(nums, target))); // [0, 1]
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { // found!
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{0, 0}; // does not exist. may return an error.
    }
}
