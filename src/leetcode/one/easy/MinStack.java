package leetcode.one.easy;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {

    public static void main(String[] args) {
        MinStack o = new MinStack();
        o.push(-2);
        o.push(0);
        o.push(-3);
        System.out.println(o.getMin()); // -3
        o.pop();
        System.out.println(o.top()); // 0
        System.out.println(o.getMin()); // -2;
    }

    Stack<IntegerWrapper> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = stack.isEmpty() ? x : Math.min(x, stack.peek().min);
        stack.push(new IntegerWrapper(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class IntegerWrapper {

        public int value;
        public int min;

        IntegerWrapper(int v, int m) {
            value = v;
            min = m;
        }
    }
}

