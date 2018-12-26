package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros o = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        o.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int wi = 0;
        for (int n : nums) {
            if (n != 0) nums[wi++] = n;
        }

        while (wi < nums.length) nums[wi++] = 0;
    }
}
