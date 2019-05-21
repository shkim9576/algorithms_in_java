package dsalg.one.linkedlist;

public class DeleteNode {

    public static void main(String[] args) {
        DeleteNode o = new DeleteNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);

        o.deleteNode(head.next.next);
        while (head != null) {
            System.out.printf("%d ", head.data);
            head = head.next;
        }
    }

    void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    static class ListNode {
        int data;
        ListNode next;
        ListNode random;

        ListNode(int d) {
            this.data = d;
        }
    }
}
