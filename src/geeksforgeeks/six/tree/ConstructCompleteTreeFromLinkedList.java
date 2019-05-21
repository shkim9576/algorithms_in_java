package geeksforgeeks.six.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructCompleteTreeFromLinkedList {

    public static void main(String[] args) {

        //25 12 30 10 36 15
        ListNode head = new ListNode(10);
        head.next = new ListNode(12);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(25);
        head.next.next.next.next = new ListNode(30);
        head.next.next.next.next.next = new ListNode(36);

        ConstructCompleteTreeFromLinkedList o = new ConstructCompleteTreeFromLinkedList();
        TreeNode root = o.buildCompleteBT(head);

        System.out.println("Inorder Traversal of the" +
                " constructed Binary Tree is:");
        o.inorder(root);
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    TreeNode buildCompleteBT(ListNode head) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(head.data);
        q.add(root);

        ListNode curr = head;
        while (curr != null) {
            TreeNode tn = q.remove();
            curr = curr.next;
            if (curr != null) {
                tn.left = new TreeNode(curr.data);
                q.add(tn.left);
            }
            curr = curr.next;
            if (curr != null) {
                tn.right = new TreeNode(curr.data);
                q.add(tn.right);
            }
        }

        return root;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int d) {
            this.data = d;
        }
    }

    static class ListNode {
        ListNode next;
        int data;

        ListNode(int d) {
            this.data = d;
        }
    }
}
