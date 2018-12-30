package leetcode.one.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/set-mismatch/
public class SetMismatch {

    public static void main(String[] args) {
        SetMismatch o = new SetMismatch();
        System.out.println(Arrays.toString(o.findErrorNums(new int[]{1, 2, 2, 4}))); //[2, 3]
    }

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int duplicate = 0;
        for (int i : nums) {
            if (set.contains(i)) duplicate = i;
            set.add(i);
            sum -= i;
        }

        return new int[]{duplicate, sum + duplicate};
    }
}
