package g4g3rd.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {64, 34, 25, 12, 22, 11, 190};
        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    static void quickSort(int[] A, int low, int high) {
        if (A == null || A.length < 1) return;

        if (low < high) {
            int pi = partition(A, low, high);
            if (low < pi-1) quickSort(A, low, pi - 1);
            if (pi < high) quickSort(A, pi, high);
        }
    }

    static int partition(int[] A, int low, int high) {
        int pivot = A[low + (high - low) / 2];
        int l=low;
        int r=high;

        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;

            if (l <= r) {
                swap(A, l++, r--);
            }
        }

        return l;
    }

    static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
