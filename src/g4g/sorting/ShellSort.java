package g4g.sorting;

import java.util.Arrays;

public class ShellSort {
    //https://www.geeksforgeeks.org/shellsort/

    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};

        ShellSort ob = new ShellSort();
        ob.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void shellSort(int[] A) {
        if (A == null || A.length <= 1) return;

        int size = A.length;
        for (int gap = size / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < size; i++) {
                int temp = A[i];
                int j;

                for (j = i; j >= gap && A[j - gap] > temp; j -= gap) {
                    A[j] = A[j - gap];
                }
                A[j] = temp;
            }
        }
    }

}
