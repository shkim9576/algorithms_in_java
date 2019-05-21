package dsalg.two.hashing;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleLinkedList {

    public static void main(String[] args) {
        DetectCycleLinkedList o = new DetectCycleLinkedList();
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = head.next;

        System.out.println(o.detectCycle(head));
    }

    boolean detectCycle(Node head) {
        Set<Node> set = new HashSet<>();

        while(head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }

        return false;
    }

    static class Node {
        int data;
        Node next;
        Node (int d) {
            this.data = d;
        }
    }
}
