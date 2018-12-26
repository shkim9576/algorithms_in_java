package leetcode.one.easy;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStack {

    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        move();
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        move();
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        move();
        return out.isEmpty();
    }

    public void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
    }
}
