package dsalg.one.linkedlist;

public class InsertNodeToSortedList {

    public static void main(String[] args) {
        InsertNodeToSortedList o = new InsertNodeToSortedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        o.insert(head, 8);

        while (head != null) {
            System.out.printf("%d ", head.data);
            head = head.next;
        }
    }

    ListNode insert(ListNode head, int d) {
        if (head == null) return null;

        ListNode curr = head;
        while (curr.next != null && curr.next.data < d) {
            curr = curr.next;
        }
        ListNode newNode = new ListNode(d);
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }
}
