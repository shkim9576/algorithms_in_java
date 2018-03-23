package g4g.sorting;

import java.util.Arrays;

public class BubbleSort {
    //https://www.geeksforgeeks.org/bubble-sort/

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
