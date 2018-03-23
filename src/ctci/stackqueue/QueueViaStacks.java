package ctci.stackqueue;

import java.util.Stack;

public class QueueViaStacks {

    public static void main(String[] args) {
        QueueViaStacks ob = new QueueViaStacks();
        ob.add(1);
        ob.add(2);
        ob.add(3);
        ob.add(4);
        ob.add(5);
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
        System.out.println(ob.remove());
    }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void add(int v) {
        s1.push(v);
    }

    int remove() {
        if (s2.isEmpty()) move();
        return (s2.isEmpty()) ? -1 : s2.pop();
    }

    void move() {
        while (!s1.isEmpty()) s2.push(s1.pop());
    }
}
