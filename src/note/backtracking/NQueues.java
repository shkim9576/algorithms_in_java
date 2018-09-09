package note.backtracking;

public class NQueues {

    static int N = 4;

    public static void main(String[] args) {
        NQueues p = new NQueues();

        boolean board[][] = new boolean[N][N];

        p.solveNQueue(board);
        p.printSolution(board);
    }

    void printSolution(boolean board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    void solveNQueue(boolean[][] board) {
        boolean result = solve(board, 0);
        System.out.println("has solution  = " + result);
    }

    boolean solve(boolean[][] board, int col) {
        if (col >= N) return true;

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; //place queue

                if (solve(board, col + 1)) {
                    return true;
                }

                board[row][col] = false; // back track;
            }
        }

        return false;
    }

    boolean isSafe(boolean[][] board, int row, int col) {
        for (int c = 0; c < col; c++) {
            if (board[row][c]) return false;
        }

        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        for (int r = row, c = col; c >= 0 && r < N; r++, c--) {
            if (board[r][c]) return false;
        }

        return true;
    }

}
