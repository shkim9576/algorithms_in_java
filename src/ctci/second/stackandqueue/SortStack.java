package ctci.second.stackandqueue;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        SortStack o = new SortStack();
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(0);
        s.push(-5);
        s.push(10);
        s.push(10);
        o.sort(s);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            int temp = s1.pop();
            while (!s2.isEmpty() && temp < s2.peek()) s1.push(s2.pop());
            s2.push(temp);
        }
        while (!s2.isEmpty()) s1.push(s2.pop());
    }
}
