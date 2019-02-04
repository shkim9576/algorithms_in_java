package ctci.first.linkedlist;

import java.util.Stack;

public class IsPalindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);

        IsPalindrome ob = new IsPalindrome();
        System.out.println(ob.isPalindrome(head));

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(3);
        head2.next.next.next.next.next = new Node(1);

        System.out.println(ob.isPalindrome(head2));
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Stack<Node> stack = new Stack<>();
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop().val != slow.val) return false;
            slow = slow.next;
        }

        return stack.isEmpty();
    }

}
