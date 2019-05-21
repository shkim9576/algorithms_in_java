package geeksforgeeks.six.linkedlist;

public class SearchElement {
    public static void main(String args[]) {

        //Start with the empty list
        LinkedList llist = new LinkedList();

        /*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);

        if (llist.searchItr(llist.head, 21))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (llist.searchRec(llist.head, 21))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        boolean searchItr(Node head, int d) {
            Node curr = head;
            while (curr != null) {
                if (curr.data == d) return true;
                curr = curr.next;
            }
            return false;
        }

        boolean searchRec(Node curr, int d) {
            if (curr == null) return false;
            if (curr.data == d) return true;
            return searchRec(curr.next, d);
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
