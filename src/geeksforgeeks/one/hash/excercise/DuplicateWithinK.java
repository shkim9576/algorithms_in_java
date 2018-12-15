package geeksforgeeks.one.hash.excercise;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWithinK {
    // https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/

    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};

        DuplicateWithinK ob = new DuplicateWithinK();
        boolean result = ob.duplicateWithinDistance(arr, 3);
        System.out.println(result);
    }

    boolean duplicateWithinDistance(int[] A, int k) {
        if (A == null || A.length <= 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int index = map.get(A[i]);
                if ((i - index) <= k) {
                    System.out.println(i + ", " + index);
                    return true;
                }
            }

            map.put(A[i], i);
        }

        return false;
    }

}
