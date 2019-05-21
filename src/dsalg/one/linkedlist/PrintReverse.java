package dsalg.one.linkedlist;

public class PrintReverse {

    public static void main(String[] args) {
        PrintReverse o = new PrintReverse();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next = new ListNode(12);

        o.printReverse(head);
    }

    void printReverse(ListNode head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.printf("%d ", head.data);
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }

}
