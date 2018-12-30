package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/transpose-matrix/
public class TransportMatrix {

    public static void main(String[] args) {
        TransportMatrix o = new TransportMatrix();

        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(o.transpose(A))); //[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
    }

    public int[][] transpose(int[][] A) {
        int numR = A.length;
        int numC = A[0].length;
        int[][] M = new int[numC][numR];

        for (int r = 0; r < numR; r++) {
            for (int c = 0; c < numC; c++) {
                M[c][r] = A[r][c];
            }
        }

        return M;
    }
}
