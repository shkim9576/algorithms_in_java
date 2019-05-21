package geeksforgeeks.six.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {

    public static void main(String[] args) {
        KLargest o = new KLargest();
        o.kLargest(new int[]{1, 23, 12, 9, 30, 2, 50}, 3);
    }

    void kLargest(int[] A, int k) {
        if (A == null || A.length < k) return;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : A) pq.add(a);

        for (int i = 0; i < k; i++) {
            int x = pq.remove();
            System.out.print(x + " ");
        }
    }
}
