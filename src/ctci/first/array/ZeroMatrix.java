package ctci.first.array;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] M = {{1, 2, 3, 5},
                     {2, 0, 1, 9},
                     {4, 1, 2, 3},
                     {0, 1, 2, 6},
                     {4, 2, 1, 8}};

        ZeroMatrix ob = new ZeroMatrix();
        ob.zeroMatrix(M);
        ob.printMatrix(M);
    }

    void printMatrix(int[][] M) {
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[0].length; c++) {
                System.out.print(M[r][c]);
            }
            System.out.println();
        }
    }

    void zeroMatrix(int[][] M) {
        int R = M.length;
        int C = M[0].length;

        boolean[] rows = new boolean[R];
        boolean[] cols = new boolean[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (M[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (rows[i]) {
                for (int c = 0; c < C; c++) M[i][c] = 0;
            }
        }

        for (int i = 0; i < C; i++) {
            if (cols[i]) {
                for (int r = 0; r < R; r++) M[r][i] = 0;
            }
        }
    }
}
