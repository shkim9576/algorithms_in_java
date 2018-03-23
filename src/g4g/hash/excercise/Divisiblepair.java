package g4g.hash.excercise;

import java.util.HashMap;
import java.util.Map;

public class Divisiblepair {
    // https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/

    public static void main(String[] args) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;

        Divisiblepair ob = new Divisiblepair();
        System.out.println(ob.canDivide(arr, k));
    }

    boolean canDivide(int[] A, int k) {
        if (A == null || A.length % 2 == 1) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : A) {
            int remainder = n % k;
            count.put(remainder, count.getOrDefault(remainder, 0) + 1);
        }

        for (int n : A) {
            int remainder = n % k;
            if ((remainder == 0 || 2 * remainder == k) && (count.get(remainder) % 2 == 1)) return false;
            else if (count.get(remainder) != count.get(k - remainder)) return false;
        }

        return true;
    }

}
