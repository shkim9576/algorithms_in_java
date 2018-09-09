package g4g3rd.sorting;

import java.util.Arrays;

public class BubbleSortRecursive {

    public static void main(String[] args) {
        int[] A = {64, 34, 25, 12, 22, 11, 190};
        bubbleSort(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    static void bubbleSort(int[] A, int n) {

        if (n <= 1) return;

        for (int i=0; i<n-1; i++) {
            if (A[i] > A[i+1]) {
                swap(A, i, i+1);
            }
        }

        bubbleSort(A, n-1);
    }

    static void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
