package ctci.second.linkedlist;

public class ReturnKthToLast {

    public static void main(String[] args) {
        ReturnKthToLast o = new ReturnKthToLast();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        //ListNode ans = o.kthToLast1(head, 3);
        //ListNode ans = o.kthToLast2(head, 3);
        ListNode ans = o.kthToLast3(head, 3, new IntegerWrapper(0));
        System.out.println(ans.val);
    }

    ListNode kthToLast3(ListNode head, int k, IntegerWrapper iw) {
        if (head == null) return null;

        ListNode node = kthToLast3(head.next, k, iw);

        if (++iw.val == k) {
            if (iw.val == k) return head;
        }
        return node;
    }

    ListNode kthToLast2(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) return null;
            curr = curr.next;
        }
        while (curr != null) {
            curr = curr.next;
            head = head.next;
        }
        return head;
    }

    ListNode kthToLast1(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        for (int i = 0; i < size - k; i++) head = head.next;

        return head;
    }

    static class IntegerWrapper {
        int val;

        IntegerWrapper(int val) {
            this.val = val;
        }
    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

}
