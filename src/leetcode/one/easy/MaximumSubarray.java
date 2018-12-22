package leetcode.one.easy;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray o = new MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; //6
        System.out.println(o.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int localMax = Integer.MIN_VALUE;
        int globalMax = Integer.MIN_VALUE;

        for (int n : nums) {
            if (localMax < 0) localMax = n;
            else localMax += n;
            globalMax = localMax > globalMax ? localMax : globalMax;
        }

        return globalMax;
    }
}
