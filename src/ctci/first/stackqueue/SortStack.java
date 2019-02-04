package ctci.first.stackqueue;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(4);

        SortStack ob = new SortStack();
        ob.sort(stack);

        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    Stack<Integer> temp = new Stack<>();

    void sort(Stack<Integer> stack) {

        while (!stack.isEmpty()) {
            int v = stack.pop();
            while (!temp.isEmpty() && temp.peek() > v) stack.push(temp.pop());
            temp.push(v);
        }
        while (!temp.isEmpty()) stack.push(temp.pop());
    }
}
