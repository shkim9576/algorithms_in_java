package geeksforgeeks.three.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] A = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }

    static void bubbleSort(int[] A) {

        for (int i = 0; i < A.length - 1; i++) {
            boolean isSwapped = false;

            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
        }
    }

    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
