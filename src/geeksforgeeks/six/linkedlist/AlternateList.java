package geeksforgeeks.six.linkedlist;

public class AlternateList {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        Node[] ans = llist.alternate(llist.head);
        llist.printList(ans[0]);
        System.out.println();
        llist.printList(ans[1]);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node[] alternate(Node head) {
            Node[] ans = new Node[2];
            Node dummyX = new Node(0);
            Node dummyY = new Node(0);
            Node curr = head, X = dummyX, Y = dummyY;

            if (head == null) return ans;

            while (curr != null) {
                X.next = curr;
                X = X.next;
                curr = curr.next;

                if (curr != null) {
                    Y.next = curr;
                    Y = Y.next;
                    curr = curr.next;
                }
            }
            X.next = null;
            Y.next = null;
            ans[0] = dummyX.next;
            ans[1] = dummyY.next;
            return ans;
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
