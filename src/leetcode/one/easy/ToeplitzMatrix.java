package leetcode.one.easy;

//https://leetcode.com/problems/toeplitz-matrix/
public class ToeplitzMatrix {

    public static void main(String[] args) {
        ToeplitzMatrix o = new ToeplitzMatrix();

        int[][] M = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(o.isToeplitzMatrix(M)); //true
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}
