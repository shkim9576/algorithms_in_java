package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {

    public static void main(String[] args) {
        RotateArray o = new RotateArray();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        o.rotate(input, 3);
        System.out.println(Arrays.toString(input)); //5,6,7,1,2,3,4
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - k - 1);
        swap(nums, 0, nums.length - 1);
    }

    void swap(int[] nums, int s, int e) {
        while (s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
    }
}
