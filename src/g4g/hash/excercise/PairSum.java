package g4g.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
    // https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two
    // -elements-in-s-whose-sum-is-exactly-x/

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;

        PairSum ob = new PairSum();
        boolean result = ob.pairSum(A, n);
        System.out.println(result);
    }

    boolean pairSum(int[] A, int x) {
        if (A == null || A.length == 0) return false;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<A.length; i++) {
            int diff = x - A[i];
            if(set.contains(A[i])) {
                System.out.println(diff + ", " + A[i]);
                return true;
            }
            set.add(diff);
        }
        return false;
    }
}
