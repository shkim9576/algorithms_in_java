package dsalg.one.linkedlist;

public class ReverseInPair {

    public static void main(String[] args) {
        ReverseInPair o = new ReverseInPair();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode ans = o.reversePairItr(head);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode reversePairItr(ListNode head) {
        ListNode temp1 = null, temp2 = null, curr = head;

        while (curr != null && curr.next != null) {
            if (temp1 != null) temp1.next.next = curr.next;

            temp1 = curr.next;
            curr.next = curr.next.next;
            temp1.next = curr;
            if (temp2 == null) temp2 = temp1;

            curr = curr.next;
        }

        return temp2;
    }

    ListNode reversePair(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;
        head.next.next = reversePair(head.next.next);

        return head;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
