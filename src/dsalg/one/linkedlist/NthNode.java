package dsalg.one.linkedlist;

public class NthNode {
    public static void main(String[] args) {
        NthNode o = new NthNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        ListNode ans = o.nthNode(head, 3);
        System.out.println(ans.data);
    }

    ListNode nthNode(ListNode head, int n) {
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            if (curr == null) return null; // error
            curr = curr.next;
        }

        ListNode ans = head;
        while (curr != null) {
            ans = ans.next;
            curr = curr.next;
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
