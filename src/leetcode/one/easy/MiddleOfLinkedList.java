package leetcode.one.easy;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        MiddleOfLinkedList o = new MiddleOfLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(o.middleNode(head).val); //3
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
