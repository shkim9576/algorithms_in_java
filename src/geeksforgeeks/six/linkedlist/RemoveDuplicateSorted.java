package geeksforgeeks.six.linkedlist;

public class RemoveDuplicateSorted {


    /* Drier program to test above functions */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        llist.printList();

        llist.removeDuplicates(llist.head);

        System.out.println("List after removal of elements");
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
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }

        void removeDuplicates(Node head) {
            if (head == null) return;

            Node slow = head, fast = head.next;
            while (fast != null) {
                if (slow.data != fast.data) {
                    slow.next = fast;
                    slow = fast;
                }
                fast = fast.next;
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
