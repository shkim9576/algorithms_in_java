package g4g.sorting;

import java.util.Arrays;

public class CountingSort {
    //https://www.geeksforgeeks.org/counting-sort/
    public static void main(String args[]) {
        CountingSort ob = new CountingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};

        ob.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void countingSort(char[] A) {
        if (A == null || A.length == 0) return;

        char[] count = new char[256];
        char[] output = new char[A.length];

        // step 1 - count each element
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        // step 2 - add prev value
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // step 3 - output from input sequence and decrease count by 1
        for (int i = 0; i < A.length; i++) {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = output[i];
        }
    }

}
