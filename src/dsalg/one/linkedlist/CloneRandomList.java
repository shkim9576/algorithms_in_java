package dsalg.one.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneRandomList {

    public static void main(String[] args) {
        CloneRandomList o = new CloneRandomList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);

        head.random = head.next.next;
        head.next.random = head.next;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next;
        head.next.next.next.next.random = head;
        head.next.next.next.next.next.random = head.next;
        head.next.next.next.next.next.next.random = head.next.next;

        ListNode ans = o.clone(head);

        while (ans != null && ans.next != null) {
            System.out.printf("[%d, %d, %d]", ans.data, ans.next.data, ans.random.data);
            ans = ans.next;
        }
    }

    ListNode clone(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        ListNode clone = null;
        ListNode ans = null;

        while (curr != null) {

            if (clone == null) {
                ans = new ListNode(curr.data);
                clone = ans;
            } else {
                clone = new ListNode(curr.data);
            }

            map.put(clone.data, clone);
            curr = curr.next;
        }

        while (head != null) {
            ListNode c = map.get(head.data);
            if (head.next != null) c.next = map.get(head.next.data);
            if (head.random != null) c.random = map.get(head.random.data);
            head = head.next;
        }

        return ans;
    }

    static class ListNode {
        int data;
        ListNode next;
        ListNode random;

        ListNode(int d) {
            this.data = d;
        }
    }
}
