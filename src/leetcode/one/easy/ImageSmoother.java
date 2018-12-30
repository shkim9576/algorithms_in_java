package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/image-smoother/
public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother o = new ImageSmoother();

        int[][] M = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(o.imageSmoother(M)));
    }

    public int[][] imageSmoother(int[][] M) {
        int numR = M.length;
        int numC = M[0].length;
        int[][] result = new int[numR][numC];
        for (int r = 0; r < numR; r++) {
            for (int c = 0; c < numC; c++) {
                result[r][c] = getAverage(M, r, c);
            }
        }

        return result;
    }

    public int getAverage(int[][] M, int r, int c) {
        int sum = 0;
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (r + i >= 0 && r + i < M.length && c + j >= 0 && c + j < M[0].length) {
                    sum += M[r + i][c + j];
                    count++;
                }
            }
        }

        return sum / count;
    }
}
