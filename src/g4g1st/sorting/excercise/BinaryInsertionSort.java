package g4g1st.sorting.excercise;

import java.util.Arrays;

public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};

        BinaryInsertionSort ob = new BinaryInsertionSort();
        ob.binaryInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void binaryInsertionSort(int[] A) {
        if (A == null || A.length <= 1) return;

        for (int i = 1; i < A.length; i++) {
            int x = A[i];
            int j = Math.abs(Arrays.binarySearch(A, 0, i, x) + 1);
            System.arraycopy(A, j, A, j + 1, i - j);
            A[j] = x;
        }
    }

}
