package leetcode.one.easy;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = n1.next;

        IntersectionOfTwoLinkedList o = new IntersectionOfTwoLinkedList();
        System.out.println(o.getIntersectionNode(n1, n2).val); // 2
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
