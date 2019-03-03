package ctci.second.stackandqueue;

import java.util.Stack;

public class StackMin {

    public static void main(String[] args) {
        MinStack o = new MinStack();
        o.push(1);
        o.push(5);
        o.push(0);
        o.push(0);
        o.push(8);
        o.push(-1);
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
    }

    static class MinStack {
        Stack<Integer> sv = new Stack<>();
        Stack<Integer> sm = new Stack<>();

        void push(int v) {
            sv.push(v);
            if (sm.isEmpty() || sm.peek() > v) sm.push(v);
            else sm.push(sm.peek());
        }

        int pop() {
            sm.pop();
            return sv.pop();
        }

        int min() {
            return sm.peek();
        }
    }
}
