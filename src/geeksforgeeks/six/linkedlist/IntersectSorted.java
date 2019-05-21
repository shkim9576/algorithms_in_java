package geeksforgeeks.six.linkedlist;

public class IntersectSorted {

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(6);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);
        l2.next.next.next = new Node(8);

        LinkedList llist = new LinkedList();
        Node ans = llist.intersect(l1, l2);
        llist.printList(ans);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node intersect(Node l1, Node l2) {
            Node dummy = new Node(0);
            Node curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.data < l2.data) {
                    l1 = l1.next;
                } else if (l1.data > l2.data) {
                    l2 = l2.next;
                } else {
                    Node nn = new Node(l1.data);
                    curr.next = nn;
                    curr = curr.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            return dummy.next;
        }

        void printList(Node head) {
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
