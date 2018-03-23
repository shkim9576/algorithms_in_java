package g4g.linkedlist.excercise;

public class SwapNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        SwapNodes ob = new SwapNodes();
        ob.printList(head);
        System.out.println("");
        head = ob.swap(head, 1, 7);
        ob.printList(head);
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }


    ListNode swap(ListNode head, int x, int y) {
        if (head == null) return head;
        if (x == y) return head;

        ListNode preX = null;
        ListNode currX = head;
        while (currX != null && currX.data != x) {
            preX = currX;
            currX = currX.next;
        }

        ListNode preY = null;
        ListNode currY = head;
        while (currY != null && currY.data != y) {
            preY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) return head; // x or y not found. therefore, cannot swap

        if (preX != null) preX.next = currY;
        else head = currY;

        if (preY != null) preY.next = currX;
        else head = currX;

        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

    void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

}
