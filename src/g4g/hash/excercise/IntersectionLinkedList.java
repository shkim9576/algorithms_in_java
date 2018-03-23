package g4g.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLinkedList {
    // https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(20);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(15);
        l1.next.next.next = new ListNode(10);

        ListNode l2 = new ListNode(10);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(8);

        IntersectionLinkedList ob = new IntersectionLinkedList();
        ListNode result = ob.intersection(l1, l2);

        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print("->");
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode intersection(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;

        Set<Integer> set = new HashSet<>();
        while(l1 != null) {
            set.add(l1.val);
            l1 = l1.next;
        }

        ListNode dummy  = new ListNode(-1);
        dummy.next = l2;
        ListNode curr = l2;
        ListNode prev = dummy;
        while(curr != null) {
            if(set.contains(curr.val)) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        return dummy.next;
    }

}
