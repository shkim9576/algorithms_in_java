package ctci.second.linkedlist;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        DeleteMiddleNode o = new DeleteMiddleNode();
        o.deleteNode(head.next.next); //3

        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }

    private boolean deleteNode(ListNode n) {
        if (n == null) return false;
        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
