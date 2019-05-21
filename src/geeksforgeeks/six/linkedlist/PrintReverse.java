package geeksforgeeks.six.linkedlist;

public class PrintReverse {

    public static void main(String args[]) {
        // Let us create linked list 1->2->3->4
        LinkedList llist = new LinkedList();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.printReverse(llist.head);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        void printReverse(Node head) {
            if (head == null) return;
            printReverse(head.next);
            System.out.print(head.data + " ");
        }

        void printList() {
            Node curr = head;
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
