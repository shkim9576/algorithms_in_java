package g4g.array.excercise;

import java.util.Arrays;

public class PairInSortedRotated {
    // https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/

    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;

        PairInSortedRotated ob = new PairInSortedRotated();
        int[] result = ob.pairInSortedRotated(arr, sum);
        System.out.println(Arrays.toString(result));
    }

    int[] pairInSortedRotated(int[] A, int sum) {
        int[] result = new int[2];
        int size = A.length;

        if (A == null || size == 0) return result;

        int l;
        for (l = size - 1; l >= 0; l--) {
            if (l == 0 || A[l] < A[l - 1]) break;
        }
        int r = (l == 0) ? size - 1 : l - 1;

        while (l != r) {
            if (A[l] + A[r] == sum) {
                result[0] = l;
                result[1] = r;
                return result;
            }

            if (A[l] + A[r] > sum) r = (r == 0) ? size - 1 : r - 1;
            else l = (l + 1) % size;
        }

        return result;
    }

}
