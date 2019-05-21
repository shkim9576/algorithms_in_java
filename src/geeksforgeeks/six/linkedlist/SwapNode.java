package geeksforgeeks.six.linkedlist;

public class SwapNode {

    /* Druver program to test above function */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print("\n Linked list before calling swapNodes() ");
        llist.printList();

        llist.swapNodes(3, 4);

        System.out.print("\n Linked list after calling swapNodes() ");
        llist.printList();
    }


    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        void swapNodes(int key1, int key2) {
            if (head == null) return;
            if (key1 == key2) return;

            Node firstPrev = null, first = head, secondPrev = null, second = head;
            while (first != null && first.data != key1) {
                firstPrev = first;
                first = first.next;
            }

            while (second != null && second.data != key2) {
                secondPrev = second;
                second = second.next;
            }

            // node does not exit
            if (first == null || second == null) return;

            // first node is head
            if (firstPrev == null) {
                head = second;
            } else {
                firstPrev.next = second;
            }

            // second node is head
            if (secondPrev == null) {
                head = first;
            } else {
                secondPrev.next = first;
            }

            // 3 , 4
            Node temp = first.next; // temp = 4
            first.next = second.next; // first.next = 5
            second.next = temp; // second.next = 4
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
