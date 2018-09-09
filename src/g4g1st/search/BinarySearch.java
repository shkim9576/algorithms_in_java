package g4g1st.search;

public class BinarySearch {
    //https://www.geeksforgeeks.org/binary-search/

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int x = 10;
        int result = binarySearch(arr, x);
        if (result == -1) System.out.println("Element not present");
        else System.out.println("Element found at index "+result);
    }

    static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}
