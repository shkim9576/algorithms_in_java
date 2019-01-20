package geeksforgeeks.five.hashmap;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(5);
        h2.next.next.next = new ListNode(6);

        unionAndIntersection(h1, h2);
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
        }
    }

    static void unionAndIntersection(ListNode n1, ListNode n2) {
        Set<Integer> union = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        ListNode curr = n1;
        while (curr != null) {
            union.add(curr.data);
            curr = curr.next;
        }

        curr = n2;
        while (curr != null) {
            if (!union.add(curr.data)) intersection.add(curr.data);
            curr = curr.next;
        }

        System.out.println(union);
        System.out.println(intersection);
    }


}
