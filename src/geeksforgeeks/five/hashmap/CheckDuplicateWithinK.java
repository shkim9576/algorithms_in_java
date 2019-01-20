package geeksforgeeks.five.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
public class CheckDuplicateWithinK {

    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        if (checkDuplicatesWithinK(arr, 3))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean checkDuplicatesWithinK(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]) && k - map.get(A[i]) > 0) return true;
            else {
                map.put(A[i], i);
            }
        }

        return false;
    }

}
