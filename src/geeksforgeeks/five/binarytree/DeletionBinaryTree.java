package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionBinaryTree {


    //Inorder traversal before deletion : 7 11 12 10 15 9 8
    //Inorder traversal after deletion : 7 8 12 10 15 9
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before deletion: ");
        Utils.inorder(root);

        int key = 11;
        deletion(root, key);

        System.out.print("\nInorder traversal after deletion : ");
        Utils.inorder(root);
    }

    static void deletion(Node root, int key) {

        Node keyNode = null;
        Node curr = null;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            curr = q.remove();

            if (curr.key == key) keyNode = curr;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        deleteBottomRight(root, curr.key);
        keyNode.key = curr.key;
    }

    static void deleteBottomRight(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            if (n.left != null) {
                if (n.left.key == key) {
                    n.left = null;
                    break;
                } else {
                    deleteBottomRight(root.left, key);
                }
            }
            if (n.right != null) {
                if (n.right.key == key) {
                    n.right = null;
                    break;
                } else {
                    deleteBottomRight(root.right, key);
                }
            }
        }
    }
}
