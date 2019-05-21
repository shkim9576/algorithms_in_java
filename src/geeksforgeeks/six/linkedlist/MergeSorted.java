package geeksforgeeks.six.linkedlist;

public class MergeSorted {


    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
        list.a = new Node(5);
        list.a.next = new Node(10);
        list.a.next.next = new Node(15);

        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(20);

        System.out.println("List a before merge :");
        list.printlist(list.a);
        System.out.println();
        System.out.println("List b before merge :");
        list.printlist(list.b);

        // merge two sorted linkedlist in decreasing order
        result = list.sortedmerge(list.a, list.b);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);

    }

    static class LinkedList {
        static Node a, b;
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node sortedmerge(Node l1, Node l2) {
            Node dummy = new Node(0);
            Node curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.data < l2.data) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null) {
                curr.next = l1;
            } else {
                curr.next = l2;
            }

            return reverse(dummy.next);
        }

        Node reverse(Node head) {
            if (head == null) return null;
            Node prev = null, curr = head, next = curr.next;
            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) next = next.next;
            }
            return prev;
        }

        void printlist(Node node) {
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
