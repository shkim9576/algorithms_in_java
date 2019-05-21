package geeksforgeeks.six.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequency {

    public static void main(String[] args) {
        NextGreaterFrequency o = new NextGreaterFrequency();

        int[] A = {1, 1, 2, 3, 4, 2, 1};
        //int[] A = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        int[] ans = o.nextGreaterFreq(A);
        System.out.println(Arrays.toString(ans));
    }

    int[] nextGreaterFreq(int[] A) {
        int[] ans = new int[A.length];
        if (A == null || A.length == 0) return ans;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && map.get(A[i]) > map.get(A[stack.peek()])) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) ans[stack.pop()] = -1;

        return ans;
    }

}
