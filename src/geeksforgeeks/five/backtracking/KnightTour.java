package geeksforgeeks.five.backtracking;

//https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
public class KnightTour {

    //00 63 58 29 02 21 06 09
    //57 30 01 34 59 08 03 20
    //62 43 28 31 22 05 10 07
    //45 56 33 60 35 12 19 04
    //42 61 44 27 32 23 16 11
    //55 46 39 36 51 18 13 24
    //38 41 48 53 26 15 50 17
    //47 54 37 40 49 52 25 14

    static int N = 8;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 2, 1};
    static int[] dy = {1, 2, 2, 1, -1, -2, -1, -2};

    public static void main(String[] args) {
        int[][] B = new int[8][8];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 8; j++) {
                B[i][j] = -1;
            }
        }

        B[0][0] = 0;
        if (dfs(0, 0, 1, B)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%02d ", B[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution");
        }
    }

    static boolean dfs(int x, int y, int count, int[][] B) {
        if (count == N * N) return true;

        for (int i = 0; i < N; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isSafe(nextX, nextY, B)) {
                B[nextX][nextY] = count;

                if (dfs(nextX, nextY, count + 1, B)) return true;
                else B[nextX][nextY] = -1;
            }
        }

        return false;
    }

    static boolean isSafe(int x, int y, int[][] B) {
        return x >= 0 && x < N && y >= 0 && y < N && B[x][y] == -1;
    }

}
