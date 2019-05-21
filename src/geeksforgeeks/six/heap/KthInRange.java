package geeksforgeeks.six.heap;

import java.util.PriorityQueue;

public class KthInRange {

    public static void main(String[] args) {
        KthInRange o = new KthInRange();
        int[] A = {3, 2, 5, 1, 8, 9};
        System.out.println(o.kthInRange(A, 2, 5, 2));
        System.out.println(o.kthInRange(A, 1, 6, 4));
    }

    int kthInRange(int[] A, int min, int max, int k) {
        if (A == null || A.length <= (max - min)) return 0; //error

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = min-1; i < max; i++) {
            pq.add(A[i]);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = pq.remove();
        }

        return ans;
    }
}
