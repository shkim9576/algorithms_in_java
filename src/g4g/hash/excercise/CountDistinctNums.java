package g4g.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctNums {
    // https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/

    public static void main(String arg[]) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        CountDistinctNums ob = new CountDistinctNums();
        List<Integer> result = ob.countDistinct(arr, k);
        System.out.println(result);
    }

    List<Integer> countDistinct(int[] A, int k) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length < k) return result;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        result.add(map.size());

        for (int i = k; i < A.length; i++) {
            int count = map.get(A[i - k]);
            if (count == 1) map.remove(A[i - k]);
            else map.put(A[i - k], map.get(A[i - k]) - 1);

            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            result.add(map.size());
        }

        return result;
    }


}
