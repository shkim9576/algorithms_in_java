package ctci.second.linkedlist;

public class Intersection {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head.next.next; //3

        Intersection o = new Intersection();
        System.out.println(o.intersection(head, head2).val);
    }

    ListNode intersection(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int l1Size = getSize(l1);
        int l2Size = getSize(l2);

        if (l1Size > l2Size) {
            for (int i = 0; i < (l1Size - l2Size); i++) l1 = l1.next;
        } else if (l2Size > l1Size) {
            for (int i = 0; i < (l2Size - l1Size); i++) l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }

    private int getSize(ListNode n) {
        if (n == null) return 0;
        ListNode curr = n;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
