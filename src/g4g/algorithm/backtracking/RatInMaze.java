package g4g.algorithm.backtracking;

public class RatInMaze {
    // https://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/

    public static void main(String[] args) {
        boolean[][] maze = {{true, false, false, false},
                            {true, true, false, true},
                            {false, true, false, false},
                            {true, true, true, true}};
        /*  output:
            1  0  0  0
            1  1  0  0
            0  1  0  0
            0  1  1  1
        */

        RatInMaze ob = new RatInMaze();
        ob.solveMaze(maze, 0, 0);
    }

    void solveMaze(boolean[][] M, int srcRow, int srcCol) {
        if (M == null || M.length == 0 || M[0].length == 0 || !M[srcRow][srcCol] || !M[M.length - 1][M[0].length - 1]) return;
        int numR = M.length;
        int numC = M[0].length;
        boolean[][] sol = new boolean[numR][numC];

        if (solveMaze(M, srcRow, srcCol, sol)) printSol(sol);
        else System.out.println("No solution");
    }

    boolean solveMaze(boolean[][] M, int row, int col, boolean[][] sol) {
        int numR = M.length;
        int numC = M[0].length;

        if (row == numR - 1 && col == numC - 1 && M[row][col]) {
            sol[row][col] = true;
            return true;
        }

        if (isSafe(M, row, col)) {
            sol[row][col] = true;
            if (solveMaze(M, row, col + 1, sol)) return true;
            if (solveMaze(M, row + 1, col, sol)) return true;
            sol[row][col] = false;
        }
        return false;
    }

    boolean isSafe(boolean[][] M, int row, int col) {
        return row >= 0 && row < M.length && col >= 0 && col < M[0].length && M[row][col];
    }

    void printSol(boolean[][] sol) {
        for (int row = 0; row < sol.length; row++) {
            for (int col = 0; col < sol[0].length; col++) {
                System.out.print(sol[row][col] + " ");
            }
            System.out.println();
        }
    }
}
