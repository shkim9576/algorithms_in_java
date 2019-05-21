package dsalg.one.backtracking;

import java.util.Arrays;

public class AllStringsOfLengthN {
    public static void main(String[] args) {
        AllStringsOfLengthN o = new AllStringsOfLengthN();

        int[] A = new int[4];
        o.kString(A, A.length - 1, 3);
    }

    private void kString(int[] A, int n, int k) {
        if (n < 0) {
            System.out.println(Arrays.toString(A));
            return;
        }

        for (int i = 0; i < k; i++) {
            A[n] = i;
            kString(A, n - 1, k);
        }
    }
}
