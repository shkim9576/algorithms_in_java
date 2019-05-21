package geeksforgeeks.six.stack;

import java.util.Stack;

public class NextGreaterElementQuery {

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6};
        int query[] = {3, 6, 1};
        int ans[] = query(arr, query);

        // getting output array
        // with next greatest elements
        for (int i = 0; i < query.length; i++) {
            // displaying the next greater
            // element for given set of queries
            System.out.print(ans[i] + " ");
        }
    }

    static int[] query(int[] A, int[] Q) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[A.length];

        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) nge[stack.pop()] = -1;

        int[] ans = new int[Q.length];
        for (int i = 0; i < ans.length; i++) {
            int index = nge[Q[i]];
            ans[i] = index == -1 ? -1 : A[index];
        }

        return ans;
    }
}
