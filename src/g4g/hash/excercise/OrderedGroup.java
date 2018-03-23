package g4g.hash.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderedGroup {
    // https://www.geeksforgeeks.org/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence/

    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 10, 10, 4, 1, 3};

        OrderedGroup ob = new OrderedGroup();
        int[] result = ob.orderedGroup(arr);
        System.out.println(Arrays.toString(result));
    }

    int[] orderedGroup(int[] A) {
        if (A == null || A.length <= 1) return A;

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int occurrence = entry.getValue();
            for (int i = 0; i < occurrence; i++) {
                result.add(element);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
