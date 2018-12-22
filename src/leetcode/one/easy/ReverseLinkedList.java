package leetcode.one.easy;

//https://leetcode.com/problems/reverse-linked-list/submissions/
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList o = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = o.reverseList(head);
        while(result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print("->");
            result = result.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
