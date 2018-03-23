package ctci.linkedlist;

public class Partition {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        Partition ob = new Partition();
        Node res = ob.partition(head, 5);

        while (res != null) {
            System.out.print(res.val);
            if (res.next != null) System.out.print("->");
            res = res.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node partition(Node head, int p) {
        Node small = new Node(-1);
        Node smallHead = small;
        Node big = new Node(-1);
        Node bigHead = big;
        Node curr = head;

        while (curr != null) {
            if (curr.val < p) {
                small.next = curr;
                small = curr;
            } else {
                big.next = curr;
                big = curr;
            }
            curr = curr.next;
        }
        small.next = bigHead.next;
        big.next = null;

        return smallHead.next;
    }
}
