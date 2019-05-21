package geeksforgeeks.six.linkedlist;

public class GetNthNode {

    public static void main(String[] args) {
        /* Start with empty list */
        LinkedList llist = new LinkedList();

        /* Use push() to construct below list
           1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        /* Check the count function */
        System.out.println("Element at index 3 is " + llist.getNthNode(3).data);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node getNthNode(int n) {
            if (head == null || n < 0) return null;

            Node curr = head;
            for (int i = 0; curr != null && i < n; i++) {
                curr = curr.next;
            }

            return curr;
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
