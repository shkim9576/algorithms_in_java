package dsalg.one.linkedlist;

public class CommonNodes {

    public static void main(String[] args) {
        CommonNodes o = new CommonNodes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(112);
        head.next.next.next.next.next.next.next = new ListNode(120);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(27);
        head2.next.next.next.next = new ListNode(29);
        head2.next.next.next.next.next = new ListNode(110);
        head2.next.next.next.next.next.next = new ListNode(112);

        ListNode ans = o.commonNodes(head, head2);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }
    }

    ListNode commonNodes(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                l1 = l1.next;
            } else if (l1.data > l2.data) {
                l2 = l2.next;
            } else {
                ans.next = new ListNode(l1.data);
                ans = ans.next;
                l1 = l1.next;
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
