package geeksforgeeks.one.sorting;

import java.util.Arrays;

public class MergeSortArray {
    // https://www.geeksforgeeks.org/merge-sort/

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        MergeSortArray ob = new MergeSortArray();
        ob.mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
    }

    void mergeSort(int[] nums, int[] temp, int l, int r) {
        if (l >= r) return;

        int m = l + (r - l) / 2;
        mergeSort(nums, temp, l, m);
        mergeSort(nums, temp, m+1, r);

        merge(nums, temp, l, m, m+1, r);
    }

    // left start, left end, right start, right end
    void merge(int[] nums, int[] temp, int ls, int le, int rs, int re) {
        int ti = 0;  // temp index
        int org = ls;
        int size = re - ls + 1;

        while (ls <= le && rs <= re) {
            if (nums[ls] > nums[rs]) temp[ti] = nums[rs++];
            else temp[ti] = nums[ls++];
            ti++;
        }

        while (ls <= le) temp[ti++] = nums[ls++];
        while (rs <= re) temp[ti++] = nums[rs++];

        for (int i=0; i<size; i++) {
            nums[org + i] = temp[i];
        }
    }

}
