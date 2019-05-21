package dsalg.two.heap;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {
        MergeKSortedList o = new MergeKSortedList();
        Node[] heads = new Node[3];
        Node one = new Node(0);
        Node two = new Node(2);
        Node three = new Node(1);
        one.next = new Node(4);
        two.next = new Node(3);
        three.next = new Node(5);
        one.next.next = new Node(6);
        two.next.next = new Node(7);
        three.next.next = new Node(8);
        two.next.next.next = new Node(9);
        two.next.next.next.next = new Node(10);

        heads[0] = one;
        heads[1] = two;
        heads[2] = three;
        Node ans = o.mergeKSorted(heads);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
    }

    Node mergeKSorted(Node[] heads) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node dummy = new Node(0);

        for (Node n : heads) pq.add(n);
        Node curr = dummy;
        while (!pq.isEmpty()) {
            Node temp = pq.remove();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) pq.add(temp.next);
        }
        return dummy.next;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
}
