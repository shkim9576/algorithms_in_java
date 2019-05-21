package dsalg.one.linkedlist;

public class EvenOdd {

    public static void main(String[] args) {
        EvenOdd o = new EvenOdd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(14);

        ListNode ans = o.evenOdd(head);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode evenOdd(ListNode head) {
        ListNode even = new ListNode(-1), odd = new ListNode(-1);
        ListNode eh = even, oh = odd;
        ListNode curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }

        even.next = oh.next;
        odd.next = null;
        return eh.next;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
