package dsalg.one.stack;

import java.util.Arrays;
import java.util.Stack;

public class FindingSpans {

    public static void main(String[] args) {
        FindingSpans o = new FindingSpans();
        int[] A = {6, 3, 4, 5, 2};
        int[] ans = o.findingSpans(A);
        System.out.println(Arrays.toString(ans));

        int[] ans2 = o.findingSpans2(A);
        System.out.println(Arrays.toString(ans2));
    }

    int[] findingSpans2(int[] A) {
        int[] ans = new int[A.length];
        ans[0] = 1;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            ans[i] = count;
        }
        return ans;
    }

    int[] findingSpans(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        int P = 0;

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }

            P = stack.isEmpty() ? -1 : stack.peek();
            ans[i] = i - P;
            stack.push(i);
        }

        return ans;
    }
}
