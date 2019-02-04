package geeksforgeeks.five.linkedlist;

//https://leetcode.com/problems/palindrome-linked-list
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList o = new PalindromeLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        System.out.println(o.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;
        ListNode reversed = reverse(slow);

        while (head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode reversed = reverse(head.next);
        if (reversed != null) reversed.next = head;
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
