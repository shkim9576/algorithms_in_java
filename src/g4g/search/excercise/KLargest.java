package g4g.search.excercise;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {
    // https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

    public static void main(String[] args) {
        int arr[] = new int[]{1, 23, 12, 9, 30, 2, 50}; // 50, 30, 23
        int k = 3;

        KLargest ob = new KLargest();
        ob.kLargest(arr, k);
    }

    void kLargest(int[] A, int k) {
        if (A == null || A.length < k) return;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : A) pq.add(i);

        for (int i = 0; i < k; i++) {
            System.out.println(pq.remove());
        }
    }

}
