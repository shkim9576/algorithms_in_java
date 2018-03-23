package ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);

        RemoveDups ob = new RemoveDups();
        ob.printList(head);
        System.out.println();

        Node res = ob.removeDups(head);
        ob.printList(res);
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node removeDups(Node head) {
        if (head == null || head.next == null) return head;

        Set<Integer> set = new HashSet<>();
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

}
