package g4g.array.excercise;

import java.util.Arrays;

public class Rotation {
    // https://www.geeksforgeeks.org/array-rotation/
    // https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Rotation ob = new Rotation();
        ob.rotate(A, 3);
        System.out.println(Arrays.toString(A));

        int[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ob.rotateReversal(B, 3);
        System.out.println(Arrays.toString(B));
    }

    void rotate(int[] A, int d) {
        if (A == null || A.length == 0) return;

        int size = A.length;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[(i + size - d) % size] = A[i];
        }

        for (int i = 0; i < size; i++) A[i] = temp[i];
   }

    void rotateReversal(int[] A, int d) {
        if (A == null || A.length == 0 || d == 0) return;

        reverse(A, 0, d - 1);
        reverse(A, d, A.length - 1);
        reverse(A, 0, A.length - 1);
    }

    void reverse(int[] A, int s, int e) {
        while (s < e) {
            int temp = A[s];
            A[s++] = A[e];
            A[e--] = temp;
        }
    }

}
