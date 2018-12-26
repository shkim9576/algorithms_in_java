package leetcode.one.easy;

//https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes o = new MaxConsecutiveOnes();
        System.out.println(o.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1})); //2
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int local = 0;
        int result = 0;

        for (int n : nums) {
            if (n == 1) local++;
            else {
                result = Math.max(result, local);
                local = 0;
            }
        }

        return Math.max(result, local);
    }
}
