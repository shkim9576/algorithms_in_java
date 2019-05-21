package geeksforgeeks.six.stack;

import java.util.Stack;

public class NumberOfNGE {

    public static void main(String args[]) {
        int a[] = {3, 4, 2, 7, 5, 8, 10, 6};
        int n = a.length;

        NumberOfNGE o = new NumberOfNGE();
        int[] ans = o.numOfNGE(a);

        // query 1 answered
        System.out.println(ans[3]);

        // query 2 answered
        System.out.println(ans[6]);

        // query 3 answered
        System.out.println(ans[1]);

    }

    int[] numOfNGE(int[] A) {
        if (A == null || A.length == 0) return null;
        int N = A.length;
        int[] ans = new int[N];

        int[] nge = buildNGE(A);

        for (int i = N - 1; i >= 0; i--) {
            if (nge[i] != -1) {
                ans[i] = ans[nge[i]] + 1;
            }
        }

        return ans;
    }

    int[] buildNGE(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] nge = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) nge[stack.pop()] = -1;
        return nge;
    }
}
