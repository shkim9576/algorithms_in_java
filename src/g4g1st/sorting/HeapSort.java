package g4g1st.sorting;


import java.util.Arrays;

public class HeapSort {
    // https://www.geeksforgeeks.org/heap-sort/
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    void heapSort(int[] A) {
        // step 1 - build a max g4g1st.heap
        // step 2 - delete a max value
        // repeat above steps

        if (A == null || A.length == 0) return;

        buildMaxHeap(A);

        for (int i = A.length - 1; i >= 0; i--) {
            swap(A, 0, i);  // delete root and move bottom one to root
            heapify(A, 0, i);  // heapify root
        }
    }

    void buildMaxHeap(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            heapify(A, i, A.length - 1);
        }
    }

    // top (curr) -> down until curr is bigger than children
    void heapify(int[] A, int curr, int size) {

        if (curr < 0 || size <= 0) return;

        int left = curr * 2 + 1;
        int right = left + 1;
        int largest = curr;

        if (left < size && A[left] > A[curr]) largest = left;
        if (right < size && A[largest] < A[right]) largest = right;

        if (largest != curr) {
            swap(A, largest, curr);
            heapify(A, largest, size);
        }
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
