package dsalg.one.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList o = new ReverseLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        o.reverseRec(head, null);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    private static ListNode ans;
    ListNode reverseRec(ListNode curr, ListNode prev) {
        if (curr.next == null) {
            ans = curr;
            curr.next = prev;
            return ans;
        }
        ListNode next1 = curr.next;
        curr.next = prev;
        reverseRec(next1, curr);

        return ans;
    }

    ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode p = null;
        ListNode c = head;
        ListNode n = c.next;

        while (c != null) {
            c.next = p;
            p = c;
            c = n;
            if (n != null) n = n.next;
        }

        return p;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
