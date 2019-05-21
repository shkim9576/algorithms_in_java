package geeksforgeeks.six.linkedlist;

public class Reverse {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(list.head);
        Node ans = list.reverse(list.head);
        System.out.println();
        System.out.println("Reversed linked list ");
        list.printList(ans);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node reverse(Node head) {
            if (head == null) return null;
            Node prev = null, curr = head, next = head.next;

            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) next = next.next;
            }

            return prev;
        }

        void printList(Node node) {
            Node curr = node;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
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
