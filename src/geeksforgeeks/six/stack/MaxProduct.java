package geeksforgeeks.six.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxProduct {

    public static void main(String args[]) {
        int[] arr = new int[]{5, 4, 3, 4, 5};
        int n = arr.length;

        System.out.print(maxProductNGE(arr));
    }

    static int maxProductNGE(int[] A) {
        if (A == null || A.length == 0) return 0;

        int[] left = new int[A.length];
        int[] right = new int[A.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                left[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) left[stack.pop()] = 0;

        stack.push(A.length - 1);
        for (int i = A.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                right[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) right[stack.pop()] = 0;

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, left[i] * right[i]);
        }

        return max;
    }
}
