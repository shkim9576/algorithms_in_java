package leetcode.one.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate-ii/submissions/
public class ContainsDuplicate2 {

    public static void main(String[] args) {
        ContainsDuplicate2 o = new ContainsDuplicate2();
        System.out.println(o.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
