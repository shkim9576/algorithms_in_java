package ctci.second.linkedlist;

public class Partition {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        Partition o = new Partition();
        //head = o.partition(head, 5);
        head = o.partition2(head, 5);

        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }

    ListNode partition2(ListNode n, int p) {
        ListNode head = n;
        ListNode tail = n;

        while (n != null) {
            ListNode next = n.next;
            if (n.val < p) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }

        tail.next = null;
        return head;
    }

    ListNode partition(ListNode head, int p) {
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode smallCurr = smallHead;
        ListNode largeCurr = largeHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < p) {
                smallCurr.next = curr;
                smallCurr = curr;
            } else {
                largeCurr.next = curr;
                largeCurr = curr;
            }
            curr = curr.next;
        }

        largeCurr.next = null;
        smallCurr.next = largeHead.next;
        return smallHead.next;
    }

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
