package ctci.second.SortingAndSearching;

import java.util.Arrays;

public class SortedMerge {

    public static void main(String[] args) {
        SortedMerge o = new SortedMerge();
        int[] A = new int[20];
        int[] AA = {-3, 1, 2, 10, 10, 12};
        System.arraycopy(AA, 0, A, 0, AA.length);
        int[] B = {-5, -3, 0, 4, 5, 15, 20, 21};
        o.merge(A, AA.length, B, B.length);
        System.out.println(Arrays.toString(A));
    }

    private void merge(int[] A, int aLength, int[] B, int bLength) {
        int ai = aLength - 1;
        int bi = bLength - 1;
        int mi = ai + bLength;

        while (ai >= 0 && bi >= 0) {
            if (A[ai] > B[bi]) A[mi--] = A[ai--];
            else A[mi--] = B[bi--];
        }

        while (bi >= 0) A[mi--] = B[bi--];
    }
}
