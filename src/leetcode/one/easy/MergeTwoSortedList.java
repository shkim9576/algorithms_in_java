package leetcode.one.easy;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {

    public static void main(String[] args) {
        MergeTwoSortedList o = new MergeTwoSortedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(10);

        //1->2->3->5->5->7->7->10
        ListNode result = o.mergeTwoLists(l1, l2);
        while(result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print("->");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}