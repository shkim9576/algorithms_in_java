package dsalg.one.stack;

import java.util.Stack;

public class Intersection {

    public static void main(String[] args) {
        Intersection o = new Intersection();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = head.next;

        ListNode ans = o.intersection(head, head2);
        System.out.println(ans.data);
    }

    ListNode intersection(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode ans = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode t1 = stack1.pop();
            ListNode t2 = stack2.pop();
            if (t1 != t2) return ans;
            ans = t1;
        }

        return null;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
