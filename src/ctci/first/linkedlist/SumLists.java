package ctci.first.linkedlist;

public class SumLists {

    public static void main(String[] args) {
        Node h1 = new Node(7);
        h1.next = new Node(1);
        h1.next.next = new Node(6);

        Node h2 = new Node(5);
        h2.next = new Node(9);
        h2.next.next = new Node(2);

        SumLists ob = new SumLists();
        Node sum = ob.sum(h1, h2);

        while (sum != null) {
            System.out.print(sum.val);
            if (sum.next != null) System.out.print("->");
            sum = sum.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node sum(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node sum = new Node(-1);
        Node res = sum;
        int carry = 0;

        while (n1 != null || n2 != null || carry == 1) {
            int n1v = (n1 == null) ? 0 : n1.val;
            int n2v = (n2 == null) ? 0 : n2.val;
            int s = n1v + n2v + carry;
            carry = (s >= 10) ? 1 : 0;
            sum.next = new Node(s % 10);
            sum = sum.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }

        return res.next;
    }
}
