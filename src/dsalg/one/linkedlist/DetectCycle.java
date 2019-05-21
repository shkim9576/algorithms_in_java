package dsalg.one.linkedlist;

public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle o = new DetectCycle();
        ListNode meet = new ListNode(9);
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = meet;
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next.next.next = meet;

        ListNode ans = o.detectCycle(head);
        System.out.println(meet == null ? "null" : ans.data);
    }

    ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
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
