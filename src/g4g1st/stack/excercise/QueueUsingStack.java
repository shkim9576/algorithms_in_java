package g4g1st.stack.excercise;

import java.util.Stack;

public class QueueUsingStack {
    // https://www.geeksforgeeks.org/queue-using-stacks/

    public static void main(String[] args) {
        QueueUsingStack ob = new QueueUsingStack();
        ob.enqueue(1);
        ob.enqueue(3);
        ob.enqueue(5);
        System.out.println(ob.dequeue());
        System.out.println(ob.dequeue());
        System.out.println(ob.dequeue());  // 1, 3, 5
    }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int data) {
        s1.push(data);
    }

    int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) move();

        return s2.pop();
    }

    void move() {
        while(!s1.isEmpty()) s2.push(s1.pop());
    }

}
