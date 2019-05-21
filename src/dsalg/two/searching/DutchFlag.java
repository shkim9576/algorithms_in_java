package dsalg.two.searching;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        DutchFlag o = new DutchFlag();
        int[] A = {0, 0, 1, 2, 2, 1, 0, 2, 1, 2, 1, 1, 0, 0, 2, 1, 0, 1, 2};
        o.dutchFlag(A);
        System.out.println(Arrays.toString(A));
    }

    void dutchFlag(int[] A) {
        int l = 0, m = 0, r = A.length - 1;
        while (m <= r) {
            switch (A[m]) {
                case 0:
                    swap(A, l, m);
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(A, m, r);
                    r--;
                    break;
            }
        }
    }

    void swap(int[] A, int l, int r) {
        int t = A[l];
        A[l] = A[r];
        A[r] = t;
    }
}
