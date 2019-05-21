package geeksforgeeks.six.linkedlist;

public class IsIdentical {

    public static void main(String args[]) {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();

        /* The constructed linked lists are :
           llist1: 3->2->1
           llist2: 3->2->1 */

        llist1.push(1);
        llist1.push(2);
        llist1.push(3);

        llist2.push(1);
        llist2.push(2);
        llist2.push(3);

        if (llist1.areIdentical(llist1.head, llist2.head))
            System.out.println("Identical ");
        else
            System.out.println("Not identical ");

    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        boolean areIdentical(Node l1, Node l2) {
            if (l1 == null || l2 == null) return l1 == l2;

            while (l1 != null && l2 != null) {
                if (l1.data != l2.data) return false;
                l1 = l1.next;
                l2 = l2.next;
            }

            return l1 == null && l2 == null;
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
