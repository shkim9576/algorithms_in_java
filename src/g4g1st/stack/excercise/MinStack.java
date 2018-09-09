package g4g1st.stack.excercise;

import java.util.Stack;

public class MinStack {
    // https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

    public static void main(String[] args) {
        MinStack ob = new MinStack();
        ob.push(3);
        ob.push(5);
        ob.push(10);
        ob.push(2);
        ob.push(7);
        System.out.println(ob.getMin()); //2
        ob.pop();
        ob.pop();
        System.out.println(ob.getMin()); //3
    }

    Stack<StackNode> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    class StackNode {
        int min;
        int data;

        StackNode(int min, int data) {
            this.min = min;
            this.data = data;
        }
    }

    void push(int data) {
        if (data < min) min = data;
        stack.push(new StackNode(min, data));
    }

    int pop() {
        return stack.pop().data;
    }

    int getMin() {
        return stack.peek().min;
    }

}
