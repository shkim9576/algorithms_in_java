package leetcode.one.easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList o = new RemoveDuplicatesFromSortedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode node = o.deleteDuplicatesRec(head);

        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("->");
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast.val == slow.val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }

        return head;
    }


    public ListNode deleteDuplicatesRec(ListNode head) {
        if (head == null || head.next == null) return head;

        head.next = deleteDuplicatesRec(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
