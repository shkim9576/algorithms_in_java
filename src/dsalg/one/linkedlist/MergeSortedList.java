package dsalg.one.linkedlist;

public class MergeSortedList {

    public static void main(String[] args) {
        MergeSortedList o = new MergeSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        head2.next.next.next.next = new ListNode(9);

        ListNode ans = o.merge(head, head2);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data < l2.data) {
            ans = l1;
            ans.next = merge(l1.next, l2);
        } else {
            ans = l2;
            ans.next = merge(l1, l2.next);
        }

        return ans;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
