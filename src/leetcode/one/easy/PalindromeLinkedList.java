package leetcode.one.easy;

import java.util.Stack;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList o = new PalindromeLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(o.isPalindrome(head)); // true
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) slow = slow.next;

        while (!stack.isEmpty() && slow != null) {
            if (stack.pop() != slow.val) return false;
            slow = slow.next;
        }

        return true;
    }
}
