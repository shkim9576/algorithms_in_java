package dsalg.one.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindIntersectingNode {

    public static void main(String[] args) {
        FindIntersectingNode o = new FindIntersectingNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = head.next;


        //ListNode ans = o.findMergePoint(head, head2);
        ListNode ans = o.findMergePointHash(head, head2);
        System.out.println(ans.data);
    }

    ListNode findMergePointHash(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return null;

        Set<ListNode> map = new HashSet<>();
        while (n1 != null) {
            map.add(n1);
            n1 = n1.next;
        }

        while (n2 != null) {
            if (map.contains(n2)) return n2;
            n2 = n2.next;
        }

        return null;
    }

    ListNode findMergePoint(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return null;

        int n1Size = getSize(n1);
        int n2Size = getSize(n2);

        if (n1Size > n2Size) {
            for (int i = 0; i < (n1Size - n2Size); i++) {
                n1 = n1.next;
            }
        } else {
            for (int i = 0; i < (n2Size - n1Size); i++) {
                n2 = n2.next;
            }
        }

        while (n1 != null && n2 != null) {
            if (n1.data == n2.data) return n1;
            n1 = n1.next;
            n2 = n2.next;
        }

        return null;
    }

    int getSize(ListNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
