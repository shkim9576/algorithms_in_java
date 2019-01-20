package geeksforgeeks.five.backtracking;

public class NQueenProblem {

    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }

    int N = 4;

    void solveNQ() {
        int[][] B = new int[N][N];

        if (dfs(B, 0)) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    System.out.printf("%01d ", B[x][y]);
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution");
        }
    }

    boolean dfs(int[][] B, int c) {
        if (c >= N) return true;

        for (int r = 0; r < N; r++) {
            if (isSafe(B, r, c)) {
                B[r][c] = 1;
                if (dfs(B, c + 1)) return true;
                B[r][c] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int[][] B, int r, int c) {
        for (int i = 0; i < c; i++) {
            if (B[r][i] == 1) return false;
        }

        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (B[i][j] == 1) return false;
        }

        for (int i = r + 1, j = c - 1; i < N && j >= 0; i++, j--) {
            if (B[i][j] == 1) return false;
        }

        return true;
    }
}
