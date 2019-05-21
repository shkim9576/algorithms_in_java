package geeksforgeeks.six.linkedlist;

public class CheckPalindrome {


    /* Driver program to test the above functions */
    public static void main(String[] args) {

        /* Start with the empty list */
        LinkedList llist = new LinkedList();

        //char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
        //char str[] = {'a', 'b', 'c', 'c', 'b', 'a'};
        char str[] = {'a', 'b', 'c', 'c', 'b', 'b'};
        for (int i = 0; i < str.length; i++) {
            llist.push(str[i]);
        }
        if (llist.isPalindrome(llist.head)) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    static class LinkedList {
        Node head;

        void push(char d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        void printList(Node head) {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }

        boolean isPalindrome(Node head) {
            Node slow = head, fast = head, slowPrev = null;

            while (fast != null && fast.next != null) {
                slowPrev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) { // odd length linked list
                slow = slow.next;
            }
            if (slowPrev != null) slowPrev.next = null;

            Node reversed = reverse(slow);
            return compare(head, reversed);
        }

        Node reverse(Node head) {
            if (head == null) return null;
            Node P = null, C = head, N = head.next;
            while (C != null) {
                C.next = P;
                P = C;
                C = N;
                if (N != null) N = N.next;
            }
            return P;
        }

        boolean compare(Node l1, Node l2) {
            while (l1 != null && l2 != null) {
                if (l1 == null || l2 == null) return false;
                if (l1.data != l2.data) return false;
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }

    static class Node {
        char data;
        Node next;

        Node(char d) {
            this.data = d;
        }
    }
}
