package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/flipping-an-image/
public class FlippingImage {

    public static void main(String[] args) {
        FlippingImage o = new FlippingImage();

        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(o.flipAndInvertImage(A))); //[[1, 0, 0], [0, 1, 0], [1, 1, 1]]
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int N = A.length - 1;
        for (int[] row : A) {
            for (int i = 0; i * 2 <= N; i++) {
                if (row[i] == row[N - i]) {
                    row[i] = row[N - i] ^= 1;
                }
            }
        }

        return A;
    }
}
