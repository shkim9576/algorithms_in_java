package ctci.second.array;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] M = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        RotateMatrix o = new RotateMatrix();
        o.rotate(M);
        System.out.println(Arrays.deepToString(M));
    }

    private void rotate(int[][] M) {
        if (M == null || M.length != M[0].length) return;
        int n = M.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                // top
                int temp = M[first][i];
                // left to top
                M[first][i] = M[last - offset][first];
                // bottom to left
                M[last - offset][first] = M[last][last - offset];
                // right to bottom
                M[last][last - offset] = M[i][last];
                // temp to top
                M[i][last] = temp;
            }
        }
    }
}
