package ctci.linkedlist;

public class LoopDetection {

    public static void main(String[] args) {
        Node loop = new Node(7);

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = loop;
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = loop;

        LoopDetection ob = new LoopDetection();
        Node res = ob.findLoop(head);
        System.out.println(res.val);
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    Node findLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
