package geeksforgeeks.one.sorting;

import java.util.Arrays;

public class InsertionSort {
    // https://www.geeksforgeeks.org/insertion-sort/

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void insertionSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
