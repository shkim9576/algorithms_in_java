package geeksforgeeks.three.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {64, 34, 25, 12, 22, 11, 190};
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
        System.out.println(Arrays.toString(A));
    }

    static void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);
            merge(A, start, middle, middle + 1, end, temp);
        }
    }

    static void merge(int[] A, int leftStart, int leftEnd, int rightStart, int rightEnd, int[] temp) {
        int tempIndex = 0;
        int orgIndex = leftStart;
        int size = rightEnd - leftStart + 1;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (A[leftStart] < A[rightStart]) {
                temp[tempIndex++] = A[leftStart++];
            } else {
                temp[tempIndex++] = A[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            temp[tempIndex++] = A[leftStart++];
        }

        while (rightStart <= rightEnd) {
            temp[tempIndex++] = A[rightStart++];
        }

        for (int i = 0; i < size; i++) {
            A[orgIndex + i] = temp[i];
        }
    }
}
