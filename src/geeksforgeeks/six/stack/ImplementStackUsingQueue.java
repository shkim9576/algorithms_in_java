package geeksforgeeks.six.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        s.pop();
        System.out.println("Top element :" + s.top());
    }

    static class MyStack {

        Queue<Integer> q = new LinkedList<>();

        void push(int d) {
            int size = q.size();
            q.add(d);
            for (int i = 0; i < size; i++) {
                q.add(q.remove());
            }
        }

        int pop() {
            return q.remove();
        }

        int top() {
            return q.peek();
        }

    }
}
