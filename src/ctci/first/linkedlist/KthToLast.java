package ctci.first.linkedlist;

public class KthToLast {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        KthToLast ob = new KthToLast();
        System.out.println(ob.kthToLast(head, 2)); // 9
        System.out.println(ob.kthToLast(head, 4)); // 5

        System.out.println(ob.kthToLastRec(head, 2)); // 9
        System.out.println(ob.kthToLastRec(head, 4)); // 5
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    static class IntWrapper {
        int i;
        IntWrapper(int i) {
            this.i = i;
        }
    }

    Node kthToLastRec(Node head, int k) {
        if (head == null) return null;
        return kthToLastRec(head, k, new IntWrapper(0));
    }

    Node kthToLastRec(Node head, int k, IntWrapper iw) {
        if (head == null) return null;

        Node node = kthToLastRec(head.next, k, iw);
        iw.i++;
        if (iw.i == k) {
            return head;
        }
        return node;
    }


    Node kthToLast(Node head, int k) {
        if (head == null) return null;

        Node curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        Node result = head;
        while (curr != null) {
            curr = curr.next;
            result = result.next;
        }
        return result;
    }

}
