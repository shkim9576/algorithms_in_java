package geeksforgeeks.six.linkedlist;

public class LengthOfLinkedList {

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Count of nodes is " + llist.getCountItr());
        System.out.println("Count of nodes is " + llist.getCountRec(llist.head));
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        int getCountItr() {
            int count = 0;
            Node curr = head;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        int getCountRec(Node curr) {
            if (curr == null) return 0;
            return getCountRec(curr.next) + 1;
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
