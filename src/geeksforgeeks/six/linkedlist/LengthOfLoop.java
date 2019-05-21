package geeksforgeeks.six.linkedlist;

public class LengthOfLoop {

    /* Driver program to test above function*/
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;

        System.out.println(countNodesinLoop(head));
    }

    static int countNodesinLoop(Node head) {
        Node slow = head, fast = head;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow == fast) {
            count++;
            while (slow.next != fast) {
                count++;
                slow = slow.next;
            }
        }

        return count;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
}
