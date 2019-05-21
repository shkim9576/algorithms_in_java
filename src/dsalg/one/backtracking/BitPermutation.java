package dsalg.one.backtracking;

import java.util.Arrays;

// Generate all the string of n bits.
public class BitPermutation {
    public static void main(String[] args) {
        BitPermutation o = new BitPermutation();
        int[] A = new int[4];
        o.binary(A, A.length-1);
    }

    private void binary(int[] A, int n) {
        if (n < 0) {
            System.out.println(Arrays.toString(A));
            return;
        }

        A[n] = 0;
        binary(A, n - 1);
        A[n] = 1;
        binary(A, n - 1);
    }
}
