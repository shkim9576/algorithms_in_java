package geeksforgeeks.one.sorting.excercise;

import java.util.Arrays;

public class Sort1ToN2 {
    // https://www.geeksforgeeks.org/sort-n-numbers-range-0-n2-1-linear-time/

    public static void main(String args[]) {
        // Since geeksforgeeks.g4g1st.one.array size is 7, elements should be from 0 to 48
        int arr[] = {40, 12, 45, 32, 33, 1, 22};

        Sort1ToN2 ob = new Sort1ToN2();
        ob.sort1ToN2(arr);
        
        System.out.println(Arrays.toString(arr));
    }

    void sort1ToN2(int[] A) {
        if (A == null || A.length == 0) return;
        radixSort(A);
    }

    void radixSort(int[] A) {
        int n = A.length;
        int max = (n * n) - 1;
        int base = n;
        for (int exp = 1; max / exp > 0; exp *= base) {
            countingSort(A, exp);
        }
    }

    void countingSort(int[] A, int exp) {
        int size = A.length;
        int[] count = new int[size];
        int[] output = new int[size];

        // count occurrence
        for (int i = 0; i < size; i++) {
            count[(A[i] / exp) % size]++;
        }

        // add prev value
        for (int i = 1; i < size; i++) {
            count[i] += count[i - 1];
        }

        // build output
        for (int i = size - 1; i >= 0; i--) {
            output[count[(A[i] / exp) % size] - 1] = A[i];
            count[(A[i] / exp) % size]--;
        }

        for (int i = 0; i < size; i++) {
            A[i] = output[i];
        }
    }

}
