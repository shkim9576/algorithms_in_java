package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray o = new ShortestUnsortedContinuousSubarray();
        System.out.println(o.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})); //5
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] cloned = nums.clone();
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (start < nums.length && cloned[start] == nums[start]) start++;
        while (end > start && cloned[end] == nums[end]) end--;

        return end - start + 1;
    }
}
