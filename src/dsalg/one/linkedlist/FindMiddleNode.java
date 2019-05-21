package dsalg.one.linkedlist;

public class FindMiddleNode {

    public static void main(String[] args) {
        FindMiddleNode o = new FindMiddleNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        //head.next.next.next.next.next.next.next = new ListNode(12);

        ListNode ans = o.findMiddleNode(head);
        System.out.println(ans.data);
    }

    ListNode findMiddleNode(ListNode head) {
        if (head == null) return null;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
