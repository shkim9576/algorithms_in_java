package leetcode.one.easy;

//https://leetcode.com/problems/remove-linked-list-elements/submissions/
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements o = new RemoveLinkedListElements();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = o.removeElementsRec(head, 6); //1->2->3->4->5
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print("->");
            result = result.next;
        }
    }

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElementsRec(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode n = head;
        while (n != null && n.next != null) {
            if (n.next.val == val) n.next = n.next.next;
            else n = n.next;
        }

        return (head.val == val) ? head.next : head;
    }
}
