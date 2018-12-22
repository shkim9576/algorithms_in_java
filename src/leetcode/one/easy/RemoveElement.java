package leetcode.one.easy;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement o = new RemoveElement();

        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(o.removeElement(nums, 2)); // 5
    }

    public int removeElement(int[] nums, int val) {
        int wi = 0;
        int ri = 0;

        for (int n : nums) {
            if (n != val) nums[wi++] = nums[ri];
            ri++;
        }

        return wi;
    }
}
