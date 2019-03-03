package ctci.second.stackandqueue;

import java.util.Stack;

public class QueueViaStacks {

    public static void main(String[] args) {
        MyQueue o = new MyQueue();
        o.push(1);
        o.push(2);
        o.push(3);
        o.push(4);
        o.push(5);
        System.out.println(o.pop());
        System.out.println(o.pop());
        System.out.println(o.pop());
        System.out.println(o.pop());
        System.out.println(o.peek());
        System.out.println(o.pop());
    }

    static class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int val) {
            s1.push(val);
        }

        int pop() {
            move();
            return s2.pop();
        }

        int peek() {
            move();
            return s2.peek();
        }

        void move() {
            if (s2.isEmpty() && !s1.isEmpty()) {
                while (!s1.isEmpty()) s2.push(s1.pop());
            }
        }
    }
}
