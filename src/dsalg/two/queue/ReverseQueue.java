package dsalg.two.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void main(String[] args) {
        ReverseQueue o = new ReverseQueue();

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);
        q.add(9);

        Queue<Integer> ans = o.reverse(q);
        System.out.println(ans);
    }

    Queue<Integer> reverse(Queue<Integer> q) {
        Queue<Integer> reversed = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) stack.push(q.remove());
        while (!stack.isEmpty()) reversed.add(stack.pop());

        return reversed;
    }
}
