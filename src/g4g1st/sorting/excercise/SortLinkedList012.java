package g4g1st.sorting.excercise;

public class SortLinkedList012 {
    // https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);

        SortLinkedList012 ob = new SortLinkedList012();
        ListNode sortedHead = ob.sort(head);

        while (sortedHead != null) {
            System.out.print(sortedHead.data);
            if (sortedHead.next != null) System.out.print("->");
            sortedHead = sortedHead.next;
        }
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    ListNode sort(ListNode head) {
        int zero = 0;
        int one = 0;
        int two = 0;

        while (head != null) {
            switch (head.data) {
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
            }
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (zero > 0) {
            curr.next = new ListNode(0);
            curr = curr.next;
            zero--;
        }

        while (one > 0) {
            curr.next = new ListNode(1);
            curr = curr.next;
            one--;
        }

        while (two > 0) {
            curr.next = new ListNode(2);
            curr = curr.next;
            two--;
        }

        return dummy.next;
    }
}
