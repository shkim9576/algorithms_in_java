package geeksforgeeks.six.linkedlist;

import java.util.Stack;

public class ReverseInSizeK {

    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        //llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse2(llist.head, 3);

        System.out.println("\nReversed list");
        llist.printList();
    }

    static class LinkedList {
        Node head;

        void push(int d) {
            Node nn = new Node(d);
            nn.next = head;
            head = nn;
        }

        Node reverse(Node head, int k) {
            if (head == null) return null;
            Node prev = null, curr = head, next = curr.next;
            int count = 0;
            while (count < k && curr != null) {
                count++;
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) next = next.next;
            }
            head.next = reverse(curr, k);
            return prev;
        }


        Node reverse2(Node head, int k) {
            Stack<Node> stack = new Stack<>();
            Node prev = null, curr = head;
            while (curr != null) {
                int count = 0;
                while (curr != null && count < k) {
                    count++;
                    stack.push(curr);
                    curr = curr.next;
                }

                while (!stack.isEmpty()) {
                    if (prev == null) {
                        Node temp = stack.pop();
                        head = temp;
                        prev = temp;
                    } else {
                        prev.next = stack.pop();
                        prev = prev.next;
                    }
                }
            }

            prev.next = null;
            return head;
        }

        void printList() {
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
