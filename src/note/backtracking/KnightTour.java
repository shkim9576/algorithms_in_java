package note.backtracking;

public class KnightTour {
    public static void main(String[] args) {
        KnightTour obj = new KnightTour();
        obj.printNightTour(8);
    }

    void printNightTour(int N) {

        int[][] M = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                M[row][col] = -1;
            }
        }

        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};
        M[0][0] = 0;

        if (nTourRec(0, 0, 1, moveX, moveY, M)) {
            printM(M);
        } else {
            System.out.println("no solution");
        }
    }

    boolean isOK(int x, int y, int[][] M) {
        int N = M[0].length;
        return x >= 0 && x < N && y >= 0 && y < N && M[x][y] == -1;
    }

    boolean nTourRec(int x, int y, int count, int[] moveX, int[] moveY, int[][] M) {
        int N = M[0].length;

        if (count == N * N) return true;
        int nextX, nextY;

        for (int k = 0; k < N; k++) {
            nextX = x + moveX[k];
            nextY = y + moveY[k];

            if (isOK(nextX, nextY, M)) {
                M[nextX][nextY] = count;

                if (nTourRec(nextX, nextY, count + 1, moveX, moveY, M)) {
                    return true;
                }

                M[nextX][nextY] = -1;
            }
        }

        return false;
    }

    void printM(int[][] M) {
        int N = M[0].length;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.printf("%02d ", M[row][col]);
            }
            System.out.println();
        }
    }
}
