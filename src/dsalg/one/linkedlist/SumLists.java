package dsalg.one.linkedlist;

import java.util.Stack;

public class SumLists {

    public static void main(String[] args) {
        SumLists o = new SumLists();

        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        ListNode ans = o.sumStack(head, head2);
        while (ans != null) {
            System.out.printf("%d ", ans.data);
            ans = ans.next;
        }

    }

    ListNode sumStack(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        while (l1 != null) {
            l1Stack.push(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Stack.push(l2.data);
            l2 = l2.next;
        }

        ListNode next = null;
        ListNode ans = null;
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry == 1) {
            int sum = carry;
            if (!l1Stack.isEmpty()) sum += l1Stack.pop();
            if (!l2Stack.isEmpty()) sum += l2Stack.pop();

            ans = new ListNode(sum % 10);
            carry = sum / 10;

            ans.next = next;
            next = ans;
        }

        return ans;
    }

    ListNode sum(ListNode l1, ListNode l2) {
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);
        if (l1Size > l2Size) {
            l2 = addZeros(l2, l1Size - l2Size);
        } else if (l2Size > l1Size) {
            l1 = addZeros(l1, l2Size - l1Size);
        }

        ListNode ans = new ListNode(0);
        int carry = sumRec(l1, l2, ans);
        if (carry == 1) {
            ListNode one = new ListNode(1);
            one.next = ans;
            ans = one;
        }

        return ans;
    }

    int sumRec(ListNode l1, ListNode l2, ListNode ans) {
        if (l1 == null || l2 == null) return 0;
        if (l1.next != null) ans.next = new ListNode(0);
        int carry = sumRec(l1.next, l2.next, ans.next);
        int sum = carry;
        sum += l1.data;
        sum += l2.data;
        ans.data = sum % 10;
        return sum / 10;
    }

    int getSize(ListNode l) {
        int size = 0;
        while (l != null) {
            l = l.next;
            size++;
        }
        return size;
    }

    ListNode addZeros(ListNode l, int size) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(0);
            curr = curr.next;
        }
        curr.next = l;
        return dummy.next;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
