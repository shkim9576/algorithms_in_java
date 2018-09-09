package g4g3rd.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] A = {64, 25, 12, 22, 11};
        selectionSort(A);
        System.out.println(Arrays.toString(A));
    }

    static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIndex = findMinIndex(i, A);
            swap(A, i, minIndex);
        }
    }

    static int findMinIndex(int startIndex, int[] A) {
        int minIndex = startIndex;
        for (int i = startIndex; i < A.length; i++) {
            if (A[i] < A[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
