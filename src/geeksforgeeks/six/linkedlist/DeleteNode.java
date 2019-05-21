package geeksforgeeks.six.linkedlist;

public class DeleteNode {

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNode(0);  // Delete node at position 4

        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        void printList() {
            Node c = head;
            while (c != null) {
                System.out.print(c.data + " ");
                c = c.next;
            }
        }

        void deleteNode(int pos) {
            if (head == null || pos < 0) return;
            if (pos == 0) {
                head = head.next;
                return;
            }

            Node prev = null, curr = head;
            int index = 0;
            while (curr != null && index < pos) {
                prev = curr;
                curr = curr.next;
                index++;
            }

            if (curr == null) return;
            prev.next = curr.next;
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
