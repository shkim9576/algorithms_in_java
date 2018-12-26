package leetcode.one.easy;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        DeleteNodeInLinkedList o = new DeleteNodeInLinkedList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        o.deleteNode(head.next); //4->1->9

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
