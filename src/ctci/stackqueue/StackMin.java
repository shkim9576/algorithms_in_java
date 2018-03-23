package ctci.stackqueue;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

    Stack<Integer> minStack = new Stack<>();

    public void push(int v) {
        super.push(v);
        if (min() >= v) minStack.push(v);
    }

    public Integer pop() {
        if (super.peek() == min()) minStack.pop();
        return super.pop();
    }

    public int min() {
        return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public static void main(String[] args) {
        StackMin ob = new StackMin();
        ob.push(4);
        ob.push(2);
        ob.push(2);
        ob.push(2);
        ob.push(3);
        ob.push(5);
        ob.push(1);
        ob.push(7);

        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
        ob.pop();
        System.out.println(ob.min());
    }

}
