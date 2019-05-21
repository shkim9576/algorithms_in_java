package dsalg.two.searching;

import java.util.Arrays;

public class AlternateArray {

    public static void main(String[] args) {
        AlternateArray o = new AlternateArray();
        int[] A = {1, 2, 3, 4, 5, 11, 12, 13, 14, 15};
        o.alternate(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    void alternate(int[] A, int l, int r) {
        int m = l + (r - l) / 2;

        if (m == l) {
            int t = A[l];
            A[l] = A[r];
            A[r] = t;
            return;
        }

        alternate(A, l, m);
        alternate(A, m + 1, r);
    }
}
