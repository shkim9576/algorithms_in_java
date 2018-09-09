package g4g1st.sorting;

import java.util.Arrays;

public class SelectionSort {
    //https://www.geeksforgeeks.org/selection-sort/

    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] nums) {
        //step 1 - have two loops (i, j)
        //step 2 - inner loop (j) : find a min value
        //step 3 - swap min value with nums[i]
        if (nums == null || nums.length == 0) return;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            int minIndex = i;

            for (int j=i+1; j<length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
