package geeksforgeeks.six.linkedlist;

public class GetNthNodeFromBack {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        System.out.println(llist.getNthNodeFromBack(4).data);
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node getNthNodeFromBack(int n) {
            if (head == null || n < 0) return null;

            Node front = head, back = head;
            for (int i = 0; i < n; i++) {
                if (front == null) return null;
                front = front.next;
            }

            while (front != null) {
                front = front.next;
                back = back.next;
            }
            return back;
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
