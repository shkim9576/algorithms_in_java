package dsalg.one.linkedlist;

public class IsEvenList {

    public static void main(String[] args) {
        IsEvenList o = new IsEvenList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        boolean ans = o.isEvenList(head);
        System.out.println(ans);
    }

    boolean isEvenList(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next.next;
        }

        return head == null;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
