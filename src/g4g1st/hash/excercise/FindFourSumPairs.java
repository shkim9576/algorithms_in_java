package g4g1st.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFourSumPairs {
    // https://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/

    public static void main(String args[]) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};

        FindFourSumPairs ob = new FindFourSumPairs();
        System.out.println(ob.findPairs(arr));
    }

    List<List<Integer>> findPairs(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        if (A == null || A.length < 4) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];

                if (map.containsKey(sum)) {
                    result.add(buildList(A[i], A[j]));
                    result.add(map.get(sum));
                    return result;
                }

                map.put(sum, buildList(A[i], A[j]));
            }
        }

        return result;
    }

    List<Integer> buildList(int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        return list;
    }
}
