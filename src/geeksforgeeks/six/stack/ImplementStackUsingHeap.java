package geeksforgeeks.six.stack;

import java.util.PriorityQueue;

public class ImplementStackUsingHeap {

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(3);
        ms.push(5);
        ms.push(7);
        ms.push(2);

        System.out.println(ms.top());
        System.out.println(ms.pop());
        System.out.println(ms.top());
        System.out.println(ms.pop());
        System.out.println(ms.top());
        System.out.println(ms.pop());
    }

    static class MyStack {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.key - a.key);
        int size = 0;

        void push(int d) {
            pq.add(new Pair(size++, d));
        }

        int pop() {
            return pq.remove().data;
        }

        int top() {
            return pq.peek().data;
        }

    }

    static class Pair {
        int key;
        int data;

        Pair(int k, int d) {
            this.key = k;
            this.data = d;
        }
    }

}
