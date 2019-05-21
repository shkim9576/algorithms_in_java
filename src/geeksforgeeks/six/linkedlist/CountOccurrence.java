package geeksforgeeks.six.linkedlist;

public class CountOccurrence {

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Use push() to construct below list
          1->2->1->3->1  */
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(3);
        llist.push(1);

        /*Checking count function*/
        System.out.println("Count of 1 is " + llist.count(llist.head, 1));
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        int count(Node head, int key) {
            Node curr = head;
            int count = 0;
            while (curr != null) {
                if (curr.data == key) count++;
                curr = curr.next;
            }
            return count;
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
