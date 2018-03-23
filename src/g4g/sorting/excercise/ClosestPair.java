package g4g.sorting.excercise;

import java.util.Arrays;

public class ClosestPair {
    // https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/

    public static void main(String args[]) {
        //int ar1[] = {1, 4, 5, 7};
        //int ar2[] = {10, 20, 30, 40};
        //int x = 38;
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x = 32;

        ClosestPair ob = new ClosestPair();
        int[] result = ob.closestPair(ar1, ar2, x);
        System.out.println(Arrays.toString(result));
    }

    int[] closestPair(int[] A1, int[] A2, int x) {
        if (A1 == null || A2 == null || A1.length == 0 || A2.length == 0) return null;

        int l = 0;
        int r = A2.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        while (l < A1.length && r >= 0) {
            int sum = A1[l] + A2[r];
            int diff = Math.abs(sum - x);
            if (diff < minDiff) {
                minDiff = diff;
                first = A1[l];
                second = A2[r];
            }
            if (sum == x) break;
            if (sum < x) l++;
            else r--;
        }

        return new int[]{first, second};
    }

}
