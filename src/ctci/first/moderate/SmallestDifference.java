package ctci.first.moderate;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] A = {10, 5, 1, 100, 20, 24, 77};
        int[] B = {30, 40, 80, 70, 60, 50};

        SmallestDifference ob = new SmallestDifference();
        System.out.println(ob.minDiff(A, B));
    }

    int minDiff(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;
        int diff = Integer.MAX_VALUE;

        while (a < A.length && b < B.length) {
            int temp = Math.abs(A[a] - B[b]);
            diff = Math.min(diff, temp);

            if (A[a] < B[b]) a++;
            else b++;
        }

        return diff;
    }
}
