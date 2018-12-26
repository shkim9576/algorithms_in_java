package leetcode.one.easy;

//https://leetcode.com/problems/missing-number/
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber o = new MissingNumber();
        System.out.println(o.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); //8
    }

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= nums.length; i++) result ^= i;
        for (int n : nums) result ^= n;

        return result;
    }
}
