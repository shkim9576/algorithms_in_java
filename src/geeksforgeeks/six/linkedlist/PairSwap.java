package geeksforgeeks.six.linkedlist;

public class PairSwap {

    /* Driver program to test above functions */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();

        Node ans = llist.pairWiseSwap(llist.head);

        System.out.println("\nLinked List after calling pairWiseSwap() ");
        //llist.printList();
        while(ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node pairWiseSwap(Node head) {
            if (head == null || head.next == null) return head;

            Node swapped = pairWiseSwap(head.next.next);

            Node next = head.next;
            next.next = head;
            head.next = swapped;

            return next;
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
