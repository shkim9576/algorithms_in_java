package geeksforgeeks.six.linkedlist;

public class MoveToFront {

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before moving last to front ");
        llist.printList(llist.head);

        Node ans = llist.moveToFront(llist.head);

        System.out.println("\nLinked List after moving last to front ");
        llist.printList(ans);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node moveToFront(Node head) {
            Node curr = head, prev = null;
            while (curr != null && curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
            return head;
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
