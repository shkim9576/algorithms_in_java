package g4g3rd.sorting;

import java.util.Arrays;

public class InsertionSortRecursive {

    public static void main(String[] args) {
        int[] A = {64, 34, 25, 12, 22, 11, 190};
        insertionSort(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    static void insertionSort(int[] A, int n) {
        if (n <= 1) return;

        insertionSort(A, n - 1);

        int target = A[n - 1];
        int index = n - 2;

        while (index >= 0 && A[index] > target) {
            A[index + 1] = A[index];
            index--;
        }
        A[index + 1] = target;
    }

}
