package leetcode.one.easy;

//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
public class LargestNumberAtleastTwiceOfOthers {

    public static void main(String[] args) {
        LargestNumberAtleastTwiceOfOthers o = new LargestNumberAtleastTwiceOfOthers();
        System.out.println(o.dominantIndex(new int[]{3, 6, 1, 0})); //1
    }

    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                result = i;
            } else if (nums[i] <= first && nums[i] > second) {
                second = nums[i];
            }
        }

        return (first >= (second * 2)) ? result : -1;
    }
}
