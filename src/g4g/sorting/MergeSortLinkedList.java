package g4g.sorting;

public class MergeSortLinkedList {
    //https://www.geeksforgeeks.org/merge-sort-for-linked-list/

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(100);
        head.next.next.next = new ListNode(-20);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(10);

        MergeSortLinkedList ob = new MergeSortLinkedList();
        ListNode node = ob.mergeSort(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode a = head;
        ListNode m = getMiddle(head);
        ListNode b = m.next;
        m.next = null;

        ListNode left = mergeSort(a);
        ListNode right = mergeSort(b);
        return merge(left, right);
    }

    ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.val <= b.val) {
            ListNode temp = a.next;
            ListNode merged = merge(temp, b);
            a.next = merged;
            return a;
        }

        ListNode temp = b.next;
        ListNode merged = merge(temp, a);
        b.next = merged;
        return b;
    }

}
