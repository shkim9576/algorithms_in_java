package geeksforgeeks.six.linkedlist;

public class SegregateEvenOdd {

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        llist.push(4);
        llist.push(1);
        llist.push(0);
        System.out.println("Origional Linked List");
        llist.printList();

        llist.segregateEvenOdd(llist.head);

        System.out.println("\nModified Linked List");
        llist.printList();
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node segregateEvenOdd(Node head) {
            Node curr = head;
            Node even = new Node(0);
            Node odd = new Node(0);
            Node evenHead = even;
            Node oddHead = odd;

            while (curr != null) {
                if (curr.data % 2 == 0) {
                    even.next = curr;
                    even = even.next;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
                curr = curr.next;
            }

            even.next = oddHead.next;
            return evenHead.next;
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
