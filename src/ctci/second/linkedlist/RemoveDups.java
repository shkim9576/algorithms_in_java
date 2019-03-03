package ctci.second.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static void main(String[] args) {
        RemoveDups o = new RemoveDups();
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);

        //ListNode ans = o.removeDups(head);
        ListNode ans = o.removeDupsWithoutBuffer(head);
        while (ans != null) {
            System.out.printf("%d ", ans.val);
            ans = ans.next;
        }
    }

    private ListNode removeDupsWithoutBuffer(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.val == curr.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
        return head;
    }

    private ListNode removeDups(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        ListNode curr = head;
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

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
