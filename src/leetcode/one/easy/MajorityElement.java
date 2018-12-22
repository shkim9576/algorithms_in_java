package leetcode.one.easy;

// https://leetcode.com/problems/majority-element/submissions/
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement o = new MajorityElement();
        System.out.println(o.majorityElement(new int[]{3, 2, 3})); //3
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1; // return error

        int count = 1;
        int major = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                major = nums[i];
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }
}
