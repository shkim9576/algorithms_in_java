package geeksforgeeks.six.linkedlist;

public class DeleteAlternate {

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling deleteAlt() ");
        llist.printList();

        llist.deleteAlternate(llist.head);
        System.out.println();
        System.out.println("Linked List after calling deleteAlt() ");
        llist.printList();
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node deleteAlternate(Node head) {
            Node curr = head;
            while (curr != null && curr.next != null) {
                curr.next = curr.next.next;
                curr = curr.next;
            }
            return head;
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
