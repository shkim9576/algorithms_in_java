package geeksforgeeks.six.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectLoop {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (llist.detectLoop(llist.head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");

        if (llist.floydCycleDetection(llist.head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        boolean detectLoop(Node head) {
            Set<Node> set = new HashSet<>();
            Node curr = head;
            while (curr != null) {
                if (set.contains(curr)) return true;
                set.add(curr);
                curr = curr.next;
            }
            return false;
        }

        boolean floydCycleDetection(Node head) {
            Node fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
}
