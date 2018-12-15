package geeksforgeeks.one.sorting.excercise;

import java.util.Arrays;

public class SortSubarray {
    // https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
    public static void main(String[] args) {
        int[] A = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}; // 3, 8

        SortSubarray ob = new SortSubarray();
        int[] result = ob.unsortedSub(A);
        System.out.println(Arrays.toString(result));

        A = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50}; // 2, 5
        result = ob.unsortedSub(A);
        System.out.println(Arrays.toString(result));
    }

    int[] unsortedSub(int[] A) {
        if (A == null || A.length <= 1) return null;

        int size = A.length;
        int l = 0;

        while (l < size - 1 && A[l] < A[l + 1]) l++;
        if (l == size - 1) return null; // all sorted

        int r = size - 1;
        while (r > 0 && A[r] > A[r - 1]) r--;
        if (r == 0) return null; // all sorted

        int min = findMin(A, l, r);
        int max = findMax(A, l, r);

        while (l >= 0 && A[l] > min) l--;
        while (r < size && A[r] < max) r++;

        return new int[]{l + 1, r - 1};
    }

    int findMin(int[] A, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) min = Math.min(min, A[i]);
        return min;
    }

    int findMax(int[] A, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) max = Math.max(max, A[i]);
        return max;
    }

}
