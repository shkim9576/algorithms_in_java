package ctci.sortingsearch;

import java.util.Arrays;

public class SortedMerge {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9, 11, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] B = {2, 4, 6, 8};

        SortedMerge ob = new SortedMerge();
        ob.merge(A, B, 6, B.length);
        System.out.println(Arrays.toString(A));
    }

    void merge(int[] A, int[] B, int lastA, int lastB) {
        int mi = lastA + lastB - 1;
        int ai = lastA - 1;
        int bi = lastB - 1;

        while (ai >= 0 && bi >= 0) {
            if (A[ai] > B[bi]) A[mi--] = A[ai--];
            else A[mi--] = B[bi--];
        }

        while (bi >= 0) A[mi--] = B[bi--];
    }

}
