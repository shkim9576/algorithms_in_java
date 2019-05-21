package geeksforgeeks.six.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateUnsorted {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates : ");
        list.printList();

        list.removeDuplicate(list.head);
        System.out.println();
        System.out.println("Linked List after removing duplicates : ");
        list.printList();
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        void removeDuplicate(Node head) {
            if (head == null) return;
            Set<Integer> set = new HashSet<>();
            Node slow = head, fast = head.next;
            set.add(slow.data);
            while (fast != null) {
                if (!set.contains(fast.data)) {
                    slow = fast;
                    set.add(fast.data);
                } else {
                    slow.next = fast.next;
                }
                fast = fast.next;
            }
        }

        void printList() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
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
