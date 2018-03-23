package ctci.moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {

    public static void main(String[] args) {
        int[][] M = {{0, 2, 1, 0},
                     {0, 1, 0, 1},
                     {1, 1, 0, 1},
                     {0, 1, 0, 1}};

        PondSizes ob = new PondSizes();
        List<Integer> res = ob.countLakes(M);
        System.out.println(res);
    }

    List<Integer> countLakes(int[][] M) {
        List<Integer> result = new ArrayList<>();
        if (M == null || M.length == 0) return result;

        int numR = M.length;
        int numC = M[0].length;

        for (int row = 0; row < numR; row++) {
            for (int col = 0; col < numC; col++) {
                if (M[row][col] == 0) {
                    int lakeSize = getLakeSize(M, row, col);
                    result.add(lakeSize);
                }
            }
        }

        return result;
    }

    int getLakeSize(int[][] M, int row, int col) {
        int numR = M.length;
        int numC = M[0].length;
        int count = 0;
        if (row >= 0 && row < numR && col >= 0 && col < numC && M[row][col] == 0) {
            count++;
            M[row][col] = -1;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    count += getLakeSize(M, row + i, col + j);
                }
            }
        }
        return count;
    }

}
