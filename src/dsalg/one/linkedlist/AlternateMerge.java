package dsalg.one.linkedlist;

public class AlternateMerge {

    public static void main(String[] args) {
        AlternateMerge o = new AlternateMerge();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(11);
        head2.next = new ListNode(12);
        head2.next.next = new ListNode(13);
        head2.next.next.next = new ListNode(14);
        head2.next.next.next.next = new ListNode(15);

        ListNode ans = o.alterateMerge(head, head2);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode alterateMerge(ListNode l1, ListNode l2) {
        ListNode ans = l1;
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next, temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
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
