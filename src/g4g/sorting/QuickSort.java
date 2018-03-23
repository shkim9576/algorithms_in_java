package g4g.sorting;

import java.util.Arrays;

public class QuickSort {
    // https://www.geeksforgeeks.org/quick-sort/

    public static void main(String args[]) {
        //int arr[] = {10, 7, 8, 9, 1, 5};
        int arr[] = {12, 3, 5, 7, 4, 19, 26};

        QuickSort ob = new QuickSort();
        ob.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] A) {
        if (A == null || A.length <= 1) return;
        quickSort(A, 0, A.length - 1);
    }

    void quickSort(int[] A, int l, int r) {
        if (l < r) {
            int partition = partition(A, l, r);
            quickSort(A, l, partition - 1);
            quickSort(A, partition + 1, r);
        }
    }

    int partition(int[] A, int l, int r) {
        int middle = l + (r - l) / 2;
        int pivot = A[middle];

        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l <= r) {
                swap(A, l, r);
                l++;
                r--;
            }
        }

        return l;
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
