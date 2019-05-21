package dsalg.one.linkedlist;

import java.util.LinkedList;

public class ImplementStackWithLinkedList {

    public static void main(String[] args) {
        ImplementStackWithLinkedList o = new ImplementStackWithLinkedList();
        o.add(1);
        o.add(3);
        o.add(5);
        o.add(7);
        System.out.println(o.remove());
        System.out.println(o.remove());
        System.out.println(o.remove());
        System.out.println(o.remove());
        System.out.println(o.remove());
    }

    LinkedList<Integer> q = new LinkedList<>();

    void add(int n) {
        int size = q.size();
        q.add(n);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    int remove() {
        if (q.isEmpty()) return -1; // error
        return q.remove();
    }
}
