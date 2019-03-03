package ctci.second.SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {

    public static void main(String[] args) {
        PeaksAndValleys o = new PeaksAndValleys();

        int[] A = {0, 8, 2, 10, 15, 20, 1, 9, 6, 3};
        o.sortValleyPeak(A);
        System.out.println(Arrays.toString(A));

        A = new int[]{0, 8, 2, 10, 15, 20, 1, 9, 6, 3, -2};
        o.sortValleyPeak(A);
        System.out.println(Arrays.toString(A));
    }

    private void sortValleyPeak(int[] A) {
        for (int i = 1; i < A.length - 1; i += 2) {
            int index = findBiggest(A, i);
            if (index != i) {
                swap(A, i, index);
            }
        }
        if (A.length % 3 == 1 && A[A.length - 1] < A[A.length - 2]) {
            swap(A, A.length - 1, A.length - 2);
        }
    }

    private int findBiggest(int[] A, int i) {
        int ans = i;
        if (i > 0 && A[i - 1] > A[ans]) ans = i - 1;
        if (i + 1 < A.length && A[i + 1] > A[ans]) ans = i + 1;
        return ans;
    }

    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
