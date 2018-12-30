package leetcode.one.easy;

//https://leetcode.com/problems/maximum-average-subarray-i/
public class MaximumAverageSubarray {

    public static void main(String[] args) {
        MaximumAverageSubarray o = new MaximumAverageSubarray();
        System.out.println(o.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); //12.75
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];

        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            max = Math.max(sum, max);
        }

        return max / k;
    }
}
