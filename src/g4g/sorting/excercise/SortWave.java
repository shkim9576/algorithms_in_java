package g4g.sorting.excercise;

import java.util.Arrays;

public class SortWave {
    // https://www.geeksforgeeks.org/sort-array-wave-form-2/

    public static void main(String args[]) {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        //int arr[] = {10, 15, 20, 7, 5, 6};
        //int arr[] = {5, 3, 1, 4, 4, 4};
        //int arr[] = {5, 5, 5, 5, 0};
        SortWave ob = new SortWave();
        ob.sortInWave(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sortInWave(int[] A) {
        if (A == null || A.length <= 1) return;

        int size = A.length;
        for (int i = 0; i < size; i += 2) {
            if (i > 0 && A[i - 1] > A[i]) {
                swap(A, i - 1, i);
            }
            if (i < size - 1 && A[i + 1] > A[i]) {
                swap(A, i + 1, i);
            }
        }
    }

    void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
