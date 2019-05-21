package geeksforgeeks.six.heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }

    void heapSort(int[] A) {
        buildHeap(A);
        sort(A);
    }

    void sort(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            heapify(A, i, 0);
        }
    }

    void buildHeap(int[] A) {
        for (int i = (A.length/2)-1; i >= 0; i--) {
            heapify(A, A.length, i);
        }
    }

    void heapify(int[] A, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[largest] < A[left]) largest = left;
        if (right < n && A[largest] < A[right]) largest = right;

        if (i != largest) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(A, n, largest);
        }
    }
}
