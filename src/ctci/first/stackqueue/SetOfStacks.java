package ctci.first.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    public static void main(String[] args) {
        SetOfStacks ob = new SetOfStacks();
        ob.push(1);
        ob.push(2);
        ob.push(3);
        ob.push(4);
        ob.push(5);
        ob.push(6);
        ob.push(7);
        System.out.println(ob.pop());
        System.out.println(ob.pop(0));
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
        System.out.println(ob.pop());
    }

    List<Stack<Integer>> list = new ArrayList<>();
    private static int THRESHOLD = 3;

    void push(int v) {
        if (list.isEmpty()) {
            list.add(new Stack<>());
        }

        Stack<Integer> stack = list.get(list.size() - 1);
        if (stack.size() >= THRESHOLD) {
            Stack<Integer> s = new Stack<>();
            s.add(v);
            list.add(s);
        } else {
            stack.add(v);
        }
    }

    int pop() {
        if (list.isEmpty()) return -1;
        Stack<Integer> stack = list.get(list.size() - 1);
        int v = stack.pop();
        if (stack.isEmpty()) list.remove(list.size() - 1);
        return v;
    }

    int pop(int i) {
        if (list.isEmpty()) return -1;
        Stack<Integer> stack = list.get(i);
        int v = stack.pop();
        if (stack.isEmpty()) list.remove(i);
        return v;
    }

}
