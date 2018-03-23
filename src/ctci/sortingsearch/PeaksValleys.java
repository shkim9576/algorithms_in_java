package ctci.sortingsearch;

import java.util.Arrays;

public class PeaksValleys {

    public static void main(String[] args) {
        int[] A = {9, 3, 1, 7, 9, 11, 13, 9};

        PeaksValleys ob = new PeaksValleys();
        ob.sort(A);
        System.out.println(Arrays.toString(A));

        A = new int[]{9, 3, 1, 7, 9, 11, 13, 9};
        ob.sortLinear(A);
        System.out.println(Arrays.toString(A));
    }

    void sort(int[] A) {
        if (A == null || A.length < 3) return;
        Arrays.sort(A);

        for (int i = 1; i < A.length; i = i + 2) {
            swap(A, i - 1, i);
        }
    }

    void sortLinear(int[] A) {
        if (A == null || A.length < 3) return;

        for (int i = 1; i < A.length; i = i + 2) {
            int maxIndex = findMaxIndex(A, i - 1, i, i + 1);
            swap(A, i, maxIndex);
        }
    }

    int findMaxIndex(int[] A, int a, int b, int c) {
        int av = (a < 0 || a >= A.length) ? Integer.MIN_VALUE : A[a];
        int bv = (b < 0 || b >= A.length) ? Integer.MIN_VALUE : A[b];
        int cv = (c < 0 || c >= A.length) ? Integer.MIN_VALUE : A[c];

        int max = Math.max(Math.max(av, bv), cv);
        if (max == av) return a;
        if (max == bv) return b;
        return c;
    }

    void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
