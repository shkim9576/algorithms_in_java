package dsalg.two.heap;

import java.util.PriorityQueue;

public class DynamicMedian {

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 5, 8};
        DynamicMedian o = new DynamicMedian();
        o.median(A);
    }

    void median(int[] A) {
        for (int i = 0; i < A.length; i++) {
            float m = findMedian(A[i]);
            System.out.println(m);
        }
    }


    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    float findMedian(int i) {
        min.add(i);
        max.add(min.remove());

        if (max.size() > min.size()) min.add(max.remove());

        if (min.size() > max.size()) return min.peek();
        return (float) ((min.peek() + max.peek()) / 2.0);
    }
}
