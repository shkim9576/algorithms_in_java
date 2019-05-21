package dsalg.one.backtracking;

public class LengthOfConnectedCells {
    public static void main(String[] args) {
        LengthOfConnectedCells o = new LengthOfConnectedCells();
        int[][] M = {{1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 1}};

        System.out.println(o.maxCount(M));
    }

    private int maxCount(int[][] M) {
        int max = 0;
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[0].length; c++) {
                if (M[r][c] == 1) {
                    max = Math.max(max, count(M, r, c));
                }
            }
        }
        return max;
    }

    private int count(int[][] M, int r, int c) {

        if (r < 0 || c < 0 || r >= M.length || c >= M[0].length || M[r][c] == 0) {
            return 0;
        }

        M[r][c] = 0;
        int cnt = 1;

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                cnt += count(M, i, j);
            }
        }


        return cnt;
    }
}
