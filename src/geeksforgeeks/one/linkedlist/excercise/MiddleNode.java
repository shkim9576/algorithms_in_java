package geeksforgeeks.one.linkedlist.excercise;

public class MiddleNode {
    // https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(13);

        MiddleNode ob = new MiddleNode();
        System.out.println(ob.findMiddle(head));
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    int findMiddle(ListNode head) {
        if (head == null || head.next == null) return -1;

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return (fast != null) ? slow.next.data : slow.data;
    }

}
