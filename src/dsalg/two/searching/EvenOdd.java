package dsalg.two.searching;

import java.util.Arrays;

public class EvenOdd {
    public static void main(String[] args) {
        EvenOdd o = new EvenOdd();
        int[] A = {1, 3, 2, 4, 6, 5, 8, 10, 10, 2, 4, 3, 7, 7, 11, 8};
        o.evenOdd(A);
        System.out.println(Arrays.toString(A));
    }

    void evenOdd(int[] A) {
        int l = 0, r = A.length - 1;

        while (l < r) {
            while (A[l] % 2 == 0 && l < r) l++;
            while (A[r] % 2 == 1 && l < r) r--;

            if (l < r) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }
    }
}
