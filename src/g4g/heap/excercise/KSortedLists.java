package g4g.heap.excercise;


import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedLists {
    // https://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(3);
        h1.next.next = new ListNode(8);

        ListNode h2 = new ListNode(4);
        h2.next = new ListNode(6);
        h2.next.next = new ListNode(30);

        ListNode h3 = new ListNode(6);
        h3.next = new ListNode(16);
        h3.next.next = new ListNode(18);

        KSortedLists ob = new KSortedLists();
        ListNode result = ob.mergeKSortedList(new ListNode[]{h1, h2, h3});

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    ListNode mergeKSortedList(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    public int compare(ListNode n1, ListNode n2) {
                        return n1.data - n2.data;
                    }
                });

        for (ListNode list : lists) {
            if (list != null) q.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (!q.isEmpty()) {
            ListNode n = q.remove();
            curr.next = n;
            curr = n;
            if (n.next != null) q.add(n.next);
        }

        return head.next;
    }

}
