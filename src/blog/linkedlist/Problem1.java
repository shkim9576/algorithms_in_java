package blog.linkedlist;

import java.util.HashSet;

public class Problem1 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(11);
        ListNode node7 = new ListNode(11);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Problem1 p = new Problem1();
        ListNode result = p.removeDuplicatesSorted(node1);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        HashSet<ListNode> set = new HashSet();
        ListNode prev = new ListNode(-1); // dummy node
        prev.next = head;
        ListNode current = head;

        while (current != null) {
            if (set.contains(current)) {
                prev.next = current.next;
            } else {
                set.add(current);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public ListNode removeDuplicatesWithoutStorage(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode first = current;
        ListNode second = first.next;

        while (current != null) {
            while(second != null) {
                if (current.data == second.data) {
                    first.next = second.next;
                } else {
                    first = first.next;
                }
                second = second.next;
            }
            current = current.next;

            if (current != null) {
                first = current;
                second = first.next;
            }
        }

        return head;
    }

    public ListNode removeDuplicatesSorted(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = first.next;

        while (second != null) {
            if (first.data == second.data) {
                first.next = second.next;
            } else {
                first = first.next;
            }

            second = second.next;
        }

        return head;
    }

}
