package geeksforgeeks.one.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class FindSnakeSequence {
    //

    public static void main(String[] args) {
        int[][] M =
                {{9, 6, 5, 2},
                 {8, 7, 6, 5},
                 {7, 3, 1, 6},
                 {1, 1, 1, 7}};
        /*      max_length = 6
                path =
                9 (0, 0)
                8 (1, 0)
                7 (1, 1)
                6 (1, 2)
                5 (1, 3)
                6 (2, 3)
                7 (3, 3)
        */
        FindSnakeSequence ob = new FindSnakeSequence();
        System.out.println(ob.maxPath(M));
    }

    int maxPath(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int R = M.length;
        int C = M[0].length;
        int[][] dp = new int[R][C];


        for (int r = 1; r < R; r++) {
            if (Math.abs(M[r - 1][0] - M[r][0]) == 1) dp[r][0] = dp[r - 1][0] + 1;
            else dp[r][0] = 0;
        }
        for (int c = 1; c < C; c++) {
            if (Math.abs(M[0][c - 1] - M[0][c]) == 1) dp[0][c] = dp[0][c - 1] + 1;
            else dp[0][c] = 0;
        }

        int max = 0;
        int maxR = 0;
        int maxC = 0;
        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (Math.abs(M[r][c] - M[r - 1][c]) == 1) dp[r][c] = Math.max(dp[r][c], dp[r - 1][c] + 1);
                if (Math.abs(M[r][c] - M[r][c - 1]) == 1) dp[r][c] = Math.max(dp[r][c], dp[r][c - 1] + 1);

                if (dp[r][c] > max) {
                    max = dp[r][c];
                    maxR = r;
                    maxC = c;
                }
            }
        }

        findPath(dp, maxR, maxC);

        return max;
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public String toString() {
            return "(" + r + ", " + c + ")";
        }
    }

    void findPath(int[][] dp, int r, int c) {
        List<Point> path = new ArrayList<>();

        path.add(new Point(r, c));

        while (dp[r][c] != 0) {
            if (r > 0 && dp[r][c] - 1 == dp[r - 1][c]) {
                path.add(new Point(r - 1, c));
                r--;
            } else if (c > 0 && dp[r][c] - 1 == dp[r][c - 1]) {
                path.add(new Point(r, c - 1));
                c--;
            }
        }

        for (int i = path.size() - 1; i >= 0; i--) System.out.println(path.get(i));
    }

}
