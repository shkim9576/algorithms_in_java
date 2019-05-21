package dsalg.two.searching;

import java.util.Arrays;

public class CloseToZeroSum {

    public static void main(String[] args) {
        CloseToZeroSum o = new CloseToZeroSum();
        int[] A = {1, 60, -10, 70, -80, 85};
        int[] ans = o.findCloseToZero(A);
        System.out.println(Arrays.toString(ans));
    }

    int[] findCloseToZero(int[] A) {
        Arrays.sort(A);

        int low = 0, high = A.length - 1;
        int[] ans = new int[2];
        int minDiff = Integer.MAX_VALUE;

        while (low < high) {
            int diff = A[high] + A[low];

            if (Math.abs(diff) < minDiff) {
                minDiff = Math.abs(diff);
                ans[0] = A[low];
                ans[1] = A[high];
            }

            if (diff > 0) {
                high--;
            } else {
                low++;
            }

        }

        return ans;
    }
}
