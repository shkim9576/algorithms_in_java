package g4g.linkedlist;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList ob = new LinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        ob.printList(head);
        System.out.println("");

        head = ob.insert(head, 10);
        head = ob.insert(head, 11);
        head = ob.insert(head, 12);
        ob.printList(head);
        System.out.println("");

        head = ob.remove(head, 12);
        head = ob.remove(head, 7);
        head = ob.remove(head, 9);
        ob.printList(head);
        System.out.println("");

        System.out.println("size = " + ob.getListSize(head));
        System.out.println("size = " + ob.getListSizeRec(head));

        System.out.println(ob.search(head, 3));
        System.out.println(ob.search(head, 5));
        System.out.println(ob.search(head, 20));
        System.out.println(ob.searchRec(head, 3));
        System.out.println(ob.searchRec(head, 5));
        System.out.println(ob.searchRec(head, 20));

    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    boolean search(ListNode head, int val) {
        if (head == null) return false;

        while(head != null) {
            if (head.data == val) return true;
            head = head.next;
        }

        return false;
    }

    boolean searchRec(ListNode head, int val) {
        if (head == null) return false;
        if (head.data == val) return true;

        return searchRec(head.next, val);
    }

    int getListSize(ListNode head) {
        if (head == null) return 0;

        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    int getListSizeRec(ListNode head) {
        if (head == null) return 0;

        return getListSizeRec(head.next) + 1;
    }

    ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }

    ListNode remove(ListNode head, int val) {
        ListNode temp = head;
        if (head.data == val) return temp.next;

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.data == val) {
                prev.next = curr.next;
                return temp;
            }
            prev = curr;
            curr = curr.next;
        }

        return temp;
    }

    void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

}
