package dsalg.one.linkedlist;

public class Reorder {

    public static void main(String[] args) {
        Reorder o = new Reorder();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode ans = o.reorder(head);
        while(ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode reorder(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow.next);
        slow.next = null;

        ListNode combined = combine(head, reversed);

        return combined;
    }

    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null, curr = head, next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr != null) next = curr.next;
        }
        return prev;
    }

    ListNode combine(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                ans.next = new ListNode(l1.data);
                ans = ans.next;
                l1 = l1.next;
            }
            if (l2 != null) {
                ans.next = new ListNode(l2.data);
                ans = ans.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
