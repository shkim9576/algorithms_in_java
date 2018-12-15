package geeksforgeeks.one.sorting.excercise;

public class UnsortedSubarray {
    // https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/

    public static void main(String[] args) {
        int[] nums = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] result = findUnsortedArray(nums);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    static int[] findUnsortedArray(int[] nums) {
        int[] result = new int[]{0, nums.length - 1}; //0,8
        if (nums == null || nums.length == 0) return result;

        int si = 0;
        int ei = nums.length - 1;
        while (si < nums.length && (si == nums.length-1 || nums[si] <= nums[si+1])) si++;

        if (si >= nums.length) return result;

        while(ei >= 0 && (ei == 0 || nums[ei] >= nums[ei-1])) ei--;

        if (ei <= 0) return result;

        int max = findMax(nums, si, ei);
        int min = findMin(nums, si, ei);

        while(si >=0 && nums[si] > min) si--;
        while(ei < nums.length && nums[ei] < max) ei++;

        return new int[]{si+1, ei-1};
    }

    static int findMin(int[] nums, int s, int e) {
        int min = Integer.MAX_VALUE;
        for(int i=s; i<=e; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }

    static int findMax(int[] nums, int s, int e) {
        int max = Integer.MIN_VALUE;
        for(int i=s; i<=e; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
