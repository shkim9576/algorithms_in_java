package g4g.algorithm.greedy;

import java.util.PriorityQueue;

public class ConnectRopesMinCost {
    // https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6}; // 29

        ConnectRopesMinCost ob = new ConnectRopesMinCost();
        System.out.println(ob.getRopeConnectionCost(ropes));
    }

    int getRopeConnectionCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int r : ropes) pq.add(r);

        int cost = 0;
        while(pq.size() >= 2) {
            int first = pq.remove();
            int second = pq.remove();
            int sum = first + second;
            cost += sum;
            pq.add(sum);
        }

        return cost;
    }

}
