package geeksforgeeks.six.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {11, 10, 13, 21, 3};
        int[] ans = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] nextGreaterElement(int[] A) {
        int[] ans = new int[A.length];
        if (A == null || A.length == 0) return ans;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {

            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                ans[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) ans[stack.pop()] = -1;

        ans[A.length - 1] = -1;
        return ans;
    }
}
