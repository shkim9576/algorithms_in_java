package geeksforgeeks.five.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/minimum-delete-operations-make-elements-array/
public class MinDeleteOperationForSameArray {

    //2
    public static void main(String[] args) {
        int arr[] = {4, 3, 4, 4, 2, 4};
        System.out.println(minDelete(arr));
    }

    static int minDelete(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
            max = Math.max(max, count.get(a));
        }
        return A.length - max;
    }
}
