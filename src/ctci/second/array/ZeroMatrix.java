package ctci.second.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ZeroMatrix {
    public static void main(String[] args) {
        ZeroMatrix o = new ZeroMatrix();
        int[][] M = {{1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 1, 1}};
        o.setZero(M);
        System.out.println(Arrays.deepToString(M));
    }

    private void setZero(int[][] M) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int R = M.length;
        int C = M[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (M[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        Iterator<Integer> itrr = rows.iterator();
        while (itrr.hasNext()) {
            int r = itrr.next();
            for (int c = 0; c < C; c++) M[r][c] = 0;
        }

        Iterator<Integer> itrc = cols.iterator();
        while (itrc.hasNext()) {
            int c = itrc.next();
            for (int r = 0; r < R; r++) M[r][c] = 0;
        }
    }


}
