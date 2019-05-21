package geeksforgeeks.six.linkedlist;

public class Intersection {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(30);
        llist.push(15);
        llist.push(9);
        llist.push(6);
        llist.push(3);

        LinkedList llist2 = new LinkedList();
        llist2.push(30);
        llist2.push(15);
        llist2.push(10);

        Node ans = llist.intersect(llist.head, llist2.head);
        System.out.println(ans.data);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node intersect(Node l1, Node l2) {
            int l1Size = 0, l2Size = 0;
            Node l1move = l1, l2move = l2;
            while (l1move != null) {
                l1move = l1move.next;
                l1Size++;
            }
            while (l2move != null) {
                l2move = l2move.next;
                l2Size++;
            }

            if (l1Size > l2Size) {
                for (int i = 0; i < (l1Size - l2Size); i++) l1 = l1.next;
            } else if (l1Size < l2Size) {
                for (int i = 0; i < (l2Size - l1Size); i++) l2 = l2.next;
            }

            while (l1 != null && l2 != null) {
                if (l1.data == l2.data) return l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            return null;
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
