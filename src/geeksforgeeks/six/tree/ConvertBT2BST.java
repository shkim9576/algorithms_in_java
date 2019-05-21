package geeksforgeeks.six.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBT2BST {

    public static void main(String[] args) {
        /* Constructing tree given in the above figure
          10
         /  \
        30   15
       /      \
      20       5   */
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        ConvertBT2BST o = new ConvertBT2BST();
        System.out.println("Before:");
        o.inorder(root);
        o.convert(root);
        System.out.println("\nAfter:");
        o.inorder(root);
    }

    int index = 0;

    void convert(Node root) {
        List<Integer> list = new ArrayList<>();
        inorderRead(root, list);
        Collections.sort(list);
        inorderWrite(root, list);
    }

    void inorderRead(Node root, List<Integer> list) {
        if (root != null) {
            inorderRead(root.left, list);
            list.add(root.data);
            inorderRead(root.right, list);
        }
    }

    void inorderWrite(Node root, List<Integer> list) {
        if (root != null) {
            inorderWrite(root.left, list);
            root.data = list.get(index++);
            inorderWrite(root.right, list);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }
}
