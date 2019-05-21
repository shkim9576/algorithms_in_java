package dsalg.two.queue;

import java.util.Stack;

public class ImplementQueueUsingStack {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

    static class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void add(int n) {
            s1.push(n);
        }

        int remove() {
            while (!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
    }
}
