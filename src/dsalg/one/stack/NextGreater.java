package dsalg.one.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        NextGreater o = new NextGreater();
        int[] A = {1, 3, 5, 7, 6, 4, 10, 15, 12, 10};
                //[1, 1, 1, 3, 2, 1, 1, 0, 0, 0]
        int[] ans = o.nextGreater(A);
        System.out.println(Arrays.toString(ans));
    }

    int[] nextGreater(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int day = stack.pop();
                ans[day] = i - day;
            }
            stack.push(i);
        }

        return ans;
    }
}
