package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
public class InsertionInBinaryTreeInLevelOrder {

    //Inorder traversal before insertion:7 11 10 15 9 8
    //Inorder traversal after insertion:7 11 12 10 15 9 8
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal before insertion: ");
        inorder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion: ");
        inorder(root);
    }

    static void insert(Node root, int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();

            if (n.left == null) {
                n.left = new Node(key);
                break;
            }
            if (n.right == null) {
                n.right = new Node(key);
                break;
            }

            q.add(n.left);
            q.add(n.right);
        }
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}
