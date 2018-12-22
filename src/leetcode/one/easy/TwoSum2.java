package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 o = new TwoSum2();
        System.out.println(Arrays.toString(o.twoSum(new int[]{2, 7, 11, 15}, 9))); // 1,2
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum < target) l++;
            else r--;
        }

        return null;
    }

}
