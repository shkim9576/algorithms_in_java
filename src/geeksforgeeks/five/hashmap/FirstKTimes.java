package geeksforgeeks.five.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/first-element-occurring-k-times-array/
public class FirstKTimes {

    // 7
    public static void main(String[] args) {
        int arr[] = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println(firstElement(arr, k));
    }

    static int firstElement(int[] A, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int i = 0;
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        for (int a : A) {
            if (count.get(a) == k) return a;
        }

        return -1;
    }

}
