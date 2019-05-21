package dsalg.two.selection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KNearestToMedian {


    public static void main(String[] args) {
        KNearestToMedian o = new KNearestToMedian();
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Set<Integer> ans = o.kNearestToMedian(A, 5);
        System.out.println(ans);
    }

    Set<Integer> kNearestToMedian(int[] A, int k) {
        int mi = findMedianIndex(A);

        Set<Integer> set = new HashSet<>();
        int li = mi - 1, ri = mi + 1;
        while (set.size() < k && li >= 0 && ri < A.length) {
            int lDiff = Math.abs(A[mi] - A[li]);
            int rDiff = Math.abs(A[mi] - A[ri]);
            if (lDiff < rDiff) set.add(A[li--]);
            else set.add(A[ri++]);
        }

        if (set.size() < k) {
            if (li < 0) {
                while (set.size() < k) set.add(A[ri++]);
            } else {
                while (set.size() < k) set.add(A[li--]);
            }
        }

        return set;
    }

    int findMedianIndex(int[] A) {
        Arrays.sort(A);
        return A.length / 2;
    }
}
