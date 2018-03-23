package ctci.array;

public class RotateImage {

    public static void main(String[] args) {
        int[][] M = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};

        RotateImage ob = new RotateImage();
        ob.rotate(M);
        ob.printMatrix(M);
    }

    void printMatrix(int[][] M) {
        for (int row = 0; row<M.length; row++) {
            for (int col=0; col<M[0].length; col++) {
                System.out.print(M[row][col] + " ");
            }
            System.out.println();
        }
    }

    void rotate(int[][] M) {
        int N = M.length;
        for (int layer = 0; layer < N/2; layer++) {
            int first = layer;
            int last = N - layer - 1;
            for (int i=first; i<last; i++) {
                int offset = i - first;
                int top = M[first][i];
                M[first][i] = M[last-offset][first]; // left to top
                M[last-offset][first] = M[last][last-offset]; // bottom to left
                M[last][last-offset] = M[i][last]; // right to bottom
                M[i][last] = top;
            }
        }
    }
}
