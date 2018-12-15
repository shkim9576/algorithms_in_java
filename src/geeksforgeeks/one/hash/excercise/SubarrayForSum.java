package geeksforgeeks.one.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayForSum {
    // https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/

    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int sum = -10; // 0, 3

        SubarrayForSum ob = new SubarrayForSum();
        System.out.println(ob.subArraySum(arr, sum));

        arr = new int[]{1, 4, 20, 3, 10, 5};
        sum = 33; // 2, 4
        System.out.println(ob.subArraySum(arr, sum));

        arr = new int[]{-10, 0, 2, -2, -20, 10};
        sum = -20; // 4, 4
        System.out.println(ob.subArraySum(arr, sum));

        arr = new int[]{-10, 0, 2, -2, -20, 10};
        sum = 20; // empty
        System.out.println(ob.subArraySum(arr, sum));
    }


    List<Integer> subArraySum(int[] A, int target) {
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (map.containsKey(sum - target)) {
                return buildResult(map.get(sum - target) + 1, i);
            }
            if (sum == target) {
                return buildResult(0, i);
            }
            if (A[i] == target) {
                return buildResult(i, i);
            }
            map.put(sum, i);
        }

        return result;
    }

    List<Integer> buildResult(int x, int y) {
        List<Integer> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        return result;
    }

}
