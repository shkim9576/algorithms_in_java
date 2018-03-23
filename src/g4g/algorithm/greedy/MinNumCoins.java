package g4g.algorithm.greedy;

import java.util.Map;
import java.util.TreeMap;

public class MinNumCoins {
    // https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/

    public static void main(String[] args) {
        int[] A = {1, 2, 5, 10, 20, 50, 100, 500, 1000}; // 50  20  20  2  1

        MinNumCoins ob = new MinNumCoins();
        ob.minNumCoins(A, 93);
    }

    void minNumCoins(int[] denom, int v) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); // <coin:how_many>
        int curr = denom.length - 1;

        while (v > 0) {
            while (curr >= 0 && denom[curr] > v) curr--;
            int div = v / denom[curr];
            if (div != 0) map.put(denom[curr], div);
            v = v % denom[curr];
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

}
