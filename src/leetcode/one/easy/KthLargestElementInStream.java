package leetcode.one.easy;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInStream {

    public static void main(String[] args) {
        KthLargestElementInStream o = new KthLargestElementInStream();
        o.test(o);
    }

    public void test(KthLargestElementInStream o) {
        KthLargest q = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(q.add(3)); //4
        System.out.println(q.add(5)); //5
        System.out.println(q.add(10)); //5
        System.out.println(q.add(9)); //8
        System.out.println(q.add(4));  //8
    }

    class KthLargest {

        PriorityQueue<Integer> q;
        int k = 0;

        public KthLargest(int k, int[] nums) {
            q = new PriorityQueue<>(k);
            this.k = k;
            for (int n : nums) add(n);
        }

        public int add(int val) {
            if (q.size() < k) q.add(val);
            else if (q.peek() < val) {
                q.remove();
                q.add(val);
            }
            return q.peek();
        }
    }
}
