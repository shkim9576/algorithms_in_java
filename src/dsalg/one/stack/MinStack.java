package dsalg.one.stack;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStackImpl o = new MinStackImpl();

        o.push(2);
        o.push(6);
        o.push(4);
        o.push(1);
        o.push(5);
        o.push(1);

        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
        System.out.println("min: " + o.getMin());
        System.out.println("pop: " + o.pop());
    }

    static class MinStackImpl {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        void push(int d) {
            if (minStack.isEmpty() || minStack.peek() >= d) minStack.push(d);
            stack.push(d);
        }

        int pop() {
            if (stack.peek() == minStack.peek()) minStack.pop();
            return stack.pop();
        }

        int getMin() {
            return minStack.peek();
        }
    }
}
