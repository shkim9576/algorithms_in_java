package g4g1st.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SymmetricPairs {
    // https://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/

    public static void main(String arg[]) {
        int arr[][] = new int[5][2];
        arr[0][0] = 11;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 5;
        arr[2][1] = 10;
        arr[3][0] = 40;
        arr[3][1] = 30;
        arr[4][0] = 10;
        arr[4][1] = 5;

        SymmetricPairs ob = new SymmetricPairs();
        List<List<Integer>> result = ob.symmetricPairs(arr);
        System.out.println(result);
    }

    List<List<Integer>> symmetricPairs(int[][] A) {
        List<List<Integer>> result = new ArrayList<>();
        if (A == null || A.length <= 1) return result;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i][0]) && map.get(A[i][0]) == A[i][1]) {
                List<Integer> pair = new LinkedList<>();
                pair.add(A[i][1]);
                pair.add(A[i][0]);
                result.add(pair);
            } else {
                map.put(A[i][1], A[i][0]);
            }
        }

        return result;
    }

}
