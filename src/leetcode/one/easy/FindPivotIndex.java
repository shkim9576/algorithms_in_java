package leetcode.one.easy;

// https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex o = new FindPivotIndex();
        System.out.println(o.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); //3
    }

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int num : nums)
            rightSum += num;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
