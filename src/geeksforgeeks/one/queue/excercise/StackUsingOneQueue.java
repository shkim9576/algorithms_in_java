package geeksforgeeks.one.queue.excercise;

import java.util.LinkedList;

public class StackUsingOneQueue {

    public static void main(String[] args) {
        StackUsingOneQueue ob = new StackUsingOneQueue();
        ob.push(1);
        ob.push(3);
        ob.push(4);
        ob.push(7);
        System.out.println(ob.pop());
        System.out.println(ob.pop());
    }

    LinkedList<Integer> q = new LinkedList<>();

    void push(int data) {
        int size = q.size();
        q.add(data);
        for(int i=0; i<size; i++) q.add(q.remove());
    }

    int pop() {
        return q.remove();
    }

}
