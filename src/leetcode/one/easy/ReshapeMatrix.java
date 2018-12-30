package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/reshape-the-matrix/
public class ReshapeMatrix {

    public static void main(String[] args) {
        ReshapeMatrix o = new ReshapeMatrix();
        int[][] m = new int[][]{{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(o.matrixReshape(m, 1, 4)));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int orgR = nums.length;
        int orgC = nums[0].length;
        if (orgR * orgC != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int curr = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                result[row][col] = nums[curr / orgC][curr % orgC];
                curr++;
            }
        }

        return result;
    }
}
