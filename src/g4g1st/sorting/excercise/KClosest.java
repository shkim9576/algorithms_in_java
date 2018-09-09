package g4g1st.sorting.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosest {
    // https://www.geeksforgeeks.org/find-k-closest-elements-given-value/

    public static void main(String args[]) {
        KClosest ob = new KClosest();
        int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}; // output : 30 39 42 45
        int x = 35, k = 4;
        int[] res = ob.kClosestToTaget(arr, k, x);
        System.out.println(Arrays.toString(res));
    }

    int[] kClosestToTaget(int[] A, int k, int target) {
        if (A == null || A.length < k) return new int[0];

        int targetIndex = binarySearch(A, target);

        List<Integer> result = new ArrayList<>();
        if (A[targetIndex] != target) result.add(A[targetIndex]);

        int l = 1;
        int r = 1;
        while (result.size() < k) {
            int rightDiff = (targetIndex + r) > A.length - 1 ? Integer.MAX_VALUE : Math.abs(A[targetIndex + r] - target);
            int leftDiff = (targetIndex - l) < 0 ? Integer.MAX_VALUE : Math.abs(A[targetIndex - l] - target);

            if (leftDiff < rightDiff) {
                result.add(A[targetIndex - l]);
                l++;
            } else {
                result.add(A[targetIndex + r]);
                r++;
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    int binarySearch(int[] A, int target) {
        int l = 0;
        int r = A.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) return m;
            else if (A[m] > target) r = m - 1;
            else l = m + 1;
        }

        return l;
    }

}
