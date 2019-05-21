package dsalg.one.linkedlist;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome o = new IsPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        boolean ans = o.isPalindrome(head);
        System.out.println(ans);

        head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);

        ans = o.isPalindrome(head);
        System.out.println(ans);

        head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);

        ans = o.isPalindrome(head);
        System.out.println(ans);
    }

    boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = head, second = slow;
        if (fast != null) { // odd
            second = slow.next;
        }

        ListNode reverse = reverse(second);

        while (reverse != null) {
            if (first.data != reverse.data) return false;
            first = first.next;
            reverse = reverse.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode prev = null, curr = head, next = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = curr.next;
        }

        return prev;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
