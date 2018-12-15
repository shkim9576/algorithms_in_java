package geeksforgeeks.one.hash.excercise;

import java.util.HashMap;
import java.util.Map;

public class PairsCountForSum {
    // https://www.geeksforgeeks.org/count-pairs-with-given-sum/

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        PairsCountForSum ob = new PairsCountForSum();
        System.out.println(ob.pairsCount(arr, sum));

        arr = new int[]{1, 1, 1, 1};
        sum = 2;
        System.out.println(ob.pairsCount(arr, sum));

    }

    int pairsCount(int[] A, int sum) {
        if (A == null || A.length <= 1) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;
        for (int n : A) {
            if (map.containsKey(sum - n)) {
                count += map.get(n);
            }
            if (n + n == sum) count--;
        }
        return count / 2;
    }

}
