package g4g1st.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class LCS {
    // https://www.geeksforgeeks.org/longest-consecutive-subsequence/

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2}; // 4

        LCS ob = new LCS();
        System.out.println(ob.findLongestConseqSubseq(arr));

        arr = new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}; // 5
        System.out.println(ob.findLongestConseqSubseq(arr));
    }

    int findLongestConseqSubseq(int[] A) {
        if (A == null || A.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n : A) set.add(n);

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            if (set.remove(A[i])) {
                count++;
                int r = 1;
                int l = 1;
                while (set.remove(A[i] + r)) {
                    count++;
                    r++;
                }
                while (set.remove(A[i] - l)) {
                    count++;
                    l++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }

}
