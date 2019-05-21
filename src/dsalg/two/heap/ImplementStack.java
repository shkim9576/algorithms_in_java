package dsalg.two.heap;

import java.util.PriorityQueue;

public class ImplementStack {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(5);
        s.push(4);
        s.push(2);

        System.out.println(s.size());
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.println();
        System.out.println(s.isEmpty());
    }

    static class MyStack {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.v - b.v);
        int priority = 0;

        void push(int i) {
            pq.add(new Pair(i, priority--));
        }

        int pop() {
            priority++;
            return pq.remove().k;
        }

        int top() {
            return pq.peek().k;
        }

        int size() {
            return pq.size();
        }

        boolean isEmpty() {
            return pq.isEmpty();
        }
    }

    static class Pair {
        int k;
        int v;

        Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}
