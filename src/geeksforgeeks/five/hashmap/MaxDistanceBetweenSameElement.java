package geeksforgeeks.five.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/maximum-distance-two-occurrences-element-array/
public class MaxDistanceBetweenSameElement {

    //10
    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(maxDistance(arr));
    }

    static int maxDistance(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                max = Math.max(max, i - map.get(A[i]));
            } else {
                map.put(A[i], i);
            }
        }

        return max;
    }

}
