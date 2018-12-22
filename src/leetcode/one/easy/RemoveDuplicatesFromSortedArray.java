package leetcode.one.easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(o.removeDuplicates(nums)); // 5

    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i == 0 || n > nums[i-1]) nums[i++] = n;
        }

        return i;
    }
}
