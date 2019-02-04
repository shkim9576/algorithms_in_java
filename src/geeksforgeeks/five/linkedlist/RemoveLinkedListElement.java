package geeksforgeeks.five.linkedlist;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElement {

    public static void main(String[] args) {
        RemoveLinkedListElement o = new RemoveLinkedListElement();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode res = o.removeElementRec(head, 6);
        while (res != null) {
            System.out.printf("%1d ", res.val);
            res = res.next;
        }
    }

    ListNode removeElementRec(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementRec(head.next, val);
        return (head.val == val) ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
