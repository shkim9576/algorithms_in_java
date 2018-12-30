package leetcode.one.easy;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch o = new BinarySearch();
        System.out.println(o.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); //4
    }

    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] > target) e = m - 1;
            else if (nums[m] < target) s = m + 1;
            else return m;
        }

        return -1;
    }
}
