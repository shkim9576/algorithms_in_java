package geeksforgeeks.one.search.excercise;

import java.util.Arrays;

public class ClosestZero {
    // https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/

    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85}; // -80, 85

        ClosestZero ob = new ClosestZero();
        int[] result = ob.minAbsSumPair(arr);
        System.out.println(Arrays.toString(result));
    }

    int[] minAbsSumPair(int[] A) {
        if (A == null || A.length < 2) return null;

        Arrays.sort(A);

        int l = 0;
        int r = A.length - 1;
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;

        while (l < r) {
            int sum = A[l] + A[r];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                minLeft = A[l];
                minRight = A[r];
            }
            if (sum < 0) l++;
            else r--;
        }

        return new int[]{minLeft, minRight};
    }

}
