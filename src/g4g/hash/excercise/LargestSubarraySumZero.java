package g4g.hash.excercise;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySumZero {
    // https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
    public static void main(String arg[]) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; // 5

        LargestSubarraySumZero ob = new LargestSubarraySumZero();
        System.out.println(ob.maxSubarraySumZero(arr));

        arr = new int[] {1, 2, 3}; // 0
        System.out.println(ob.maxSubarraySumZero(arr));

        arr = new int[] {1, 0, 3}; // 1
        System.out.println(ob.maxSubarraySumZero(arr));

    }

    int maxSubarraySumZero(int[] A) {
        if (A == null || A.length == 0) return 0;

        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLen = Math.max(maxLen, length);
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

}
