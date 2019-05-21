package dsalg.two.searching;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum o = new ThreeSum();
        int[] A = {2, 11, 1, 20, 5, 7, 4, 6, 3};
        int[] ans = o.threeSum(A, 10);
        System.out.println(Arrays.toString(ans));
    }

    int[] threeSum(int[] A, int k) {
        Arrays.sort(A);
        int[] ans = new int[3];
        for (int i = 0; i < A.length - 2; i++) {
            int low = i + 1, high = A.length - 1;
            while (low < high) {
                int sum = A[i] + A[low] + A[high];
                if (sum == k) {
                    ans[0] = A[i];
                    ans[1] = A[low];
                    ans[2] = A[high];
                    break;
                } else if (sum < k) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return ans;
    }
}
