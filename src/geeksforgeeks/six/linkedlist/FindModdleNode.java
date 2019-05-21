package geeksforgeeks.six.linkedlist;

public class FindModdleNode {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            System.out.println(llist.findMiddle(llist.head).data);
        }
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node findMiddle(Node head) {
            if (head == null) return null;
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
}
