package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity/
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity o = new SortArrayByParity();
        System.out.println(Arrays.toString(o.sortArrayByParity(new int[]{3, 1, 2, 4}))); //[2, 4, 3, 1]
    }

    public int[] sortArrayByParity(int[] A) {
        for (int ri = 0, wi = 0; ri < A.length; ri++) {
            if (A[ri] % 2 == 0) {
                int t = A[ri];
                A[ri] = A[wi];
                A[wi] = t;
                wi++;
            }
        }
        return A;
    }
}
