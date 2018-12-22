package leetcode.one.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition o = new SearchInsertPosition();

        int[] nums = {1,3,5,6};
        System.out.println(o.searchInsert(nums, 5)); //2
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while(low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
