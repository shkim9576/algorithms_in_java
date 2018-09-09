package note.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] A = new int[]{4, 8, 2, 10, 2, 3, 4};
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(A);
        System.out.println(Arrays.toString(A));
    }

    public void countingSort(int[] A) {
        if (A == null || A.length < 2) return;

        //step 1. find max and min
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int e : A) {
            min = Math.min(e, min);
            max = Math.max(e, max);
        }

        //step 2. count
        int[] freqArray = new int[max - min + 1];
        for (int e : A) {
            freqArray[e - min]++;
        }

        //step 3. add prev sum + current count
        for (int i = 1; i < freqArray.length; i++) {
            freqArray[i] += freqArray[i - 1];
        }

        //step 4. build output and decrease count
        int[] output = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            output[freqArray[A[i] - min]] = A[i];
            freqArray[A[i] - min]--;
        }

        for (int i = 1; i < A.length; i++) {
            A[i - 1] = output[i];
        }
    }
}
