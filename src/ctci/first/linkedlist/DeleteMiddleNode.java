package ctci.first.linkedlist;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);

        DeleteMiddleNode ob = new DeleteMiddleNode();
        System.out.println(ob.delete(head.next));

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    boolean delete(Node n) {
        if (n == null || n.next == null) return false;
        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }
}
