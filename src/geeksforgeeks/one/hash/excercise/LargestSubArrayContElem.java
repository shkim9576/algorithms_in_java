package geeksforgeeks.one.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class LargestSubArrayContElem {
    // https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/

    public static void main(String[] args) {
        int arr[] = {10, 12, 12, 10, 10, 11, 10}; // 12

        LargestSubArrayContElem ob = new LargestSubArrayContElem();
        System.out.println(ob.findLength(arr));

        arr = new int[]{10, 12, 11}; // 3
        System.out.println(ob.findLength(arr));
    }

    int findLength(int[] A) {
        if (A == null || A.length == 0) return 0;

        int maxLen = 0;
        for (int i = 0; i < A.length - 1; i++) {

            int max = A[i];
            int min = A[i];
            Set<Integer> set = new HashSet<>();
            set.add(A[i]);

            for (int j = i + 1; j < A.length; j++) {
                if (set.contains(A[j])) break;

                set.add(A[j]);
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);

                if ((max - min) == (j - i)) {
                    maxLen = Math.max(maxLen, (j - i) + 1);
                }
            }
        }

        return maxLen;
    }


}
