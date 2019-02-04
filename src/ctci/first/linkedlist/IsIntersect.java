package ctci.first.linkedlist;

public class IsIntersect {

    public static void main(String[] args) {
        Node interNode = new Node(3);

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = interNode;
        head.next.next.next.next = new Node(1);

        Node head2 = new Node(10);
        head2.next = new Node(11);
        head2.next.next = interNode;
        head2.next.next.next = new Node(13);

        IsIntersect ob = new IsIntersect();
        System.out.println(ob.isIntersect(head, head2));
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    boolean isIntersect(Node h1, Node h2) {
        int l1 = getLength(h1);
        int l2 = getLength(h2);
        int diff = Math.abs(l1 - l2);

        Node longer = (l1 > l2) ? h1 : h2;
        Node shorter = (l1 > l2) ? h2 : h1;

        while (longer != null && diff > 0) {
            longer = longer.next;
            diff--;
        }

        while (longer != null && shorter != null) {
            if (longer == shorter) {
                System.out.println(longer.val);
                return true;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return false;
    }

    int getLength(Node n) {
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

}
