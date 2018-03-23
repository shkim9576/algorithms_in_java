package g4g.heap.excercise;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    // https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9, 10, 2};

        Median ob = new Median();
        System.out.println(ob.getMedian(A));
    }

    int getMedian(int[] A) {
        if (A == null || A.length == 0) return 0;

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int n : A) {
            max.add(n);
            min.add(max.remove());
            if (min.size() > max.size()) max.add(min.remove());
        }

        int maxVal = max.remove();
        int minVal = min.remove();
        return max.size() == min.size() ? (maxVal + minVal) / 2 : minVal;
    }

}
