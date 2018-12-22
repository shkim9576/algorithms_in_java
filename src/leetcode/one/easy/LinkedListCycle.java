package leetcode.one.easy;

import geeksforgeeks.one.linkedlist.LinkedList;

// https://leetcode.com/problems/linked-list-cycle/submissions/
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        LinkedListCycle o = new LinkedListCycle();
        System.out.println(o.hasCycle(head)); //true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.val == fast.val) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
