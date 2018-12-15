package geeksforgeeks.three.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] A = {12, 11, 13, 5, 6};
        insertionSort(A);
        System.out.println(Arrays.toString(A));
    }

    static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            int target = A[i];

            while (j > 0 && A[j - 1] > target) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = target;
        }
    }

}
