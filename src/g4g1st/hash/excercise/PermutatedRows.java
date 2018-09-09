package g4g1st.hash.excercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutatedRows {
    // https://www.geeksforgeeks.org/find-permuted-rows-given-row-matrix/

    public static void main(String[] args) {
        int r = 3;
        int mat[][] = {{3, 1, 4, 2},
                       {1, 6, 9, 3},
                       {1, 2, 3, 4},
                       {4, 3, 2, 1}};

        PermutatedRows ob = new PermutatedRows();
        List<Integer> result = ob.permutatedRows(mat, r);
        System.out.println(result);
    }

    List<Integer> permutatedRows(int[][] M, int r) {
        List<Integer> result = new ArrayList<>();
        if (M == null || M.length < r) return result;

        Set<Integer> targetSet = buildSet(M[r]);
        for (int i = 0; i < M.length; i++) {
            if (i == r) continue;
            Set<Integer> localSet = buildSet(M[i]);
            if (localSet.equals(targetSet)) result.add(i);
        }

        return result;
    }

    Set<Integer> buildSet(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        return set;
    }

}
