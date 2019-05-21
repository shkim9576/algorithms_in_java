package dsalg.one.stack;

import java.util.Stack;

public class ConsecurivePair {

    public static void main(String[] args) {
        ConsecurivePair o = new ConsecurivePair();

        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(6);
        stack.push(5);
        stack.push(10);
        stack.push(11);
        stack.push(-3);
        stack.push(-2);
        stack.push(5);
        stack.push(4);
        System.out.println(o.isConsecutivePair(stack));
    }

    boolean isConsecutivePair(Stack<Integer> stack) {
        if (stack == null) return true;

        while (!stack.isEmpty()) {
            int f = stack.pop();
            if (stack.isEmpty()) return true;

            int s = stack.pop();
            if (Math.abs(f - s) != 1) return false;
        }

        return true;
    }
}
