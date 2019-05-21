package geeksforgeeks.six.heap;

import java.util.PriorityQueue;

public class ConnectRopeMinCost {

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        ConnectRopeMinCost o = new ConnectRopeMinCost();
        System.out.println("Total cost for connecting ropes is " + o.minCost(A));

    }

    int minCost(int[] A) {
        if (A == null || A.length == 0) return 0;

        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : A) pq.add(a);

        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            int sum = first + second;
            total += sum;
            pq.add(sum);
        }

        return total;
    }
}
