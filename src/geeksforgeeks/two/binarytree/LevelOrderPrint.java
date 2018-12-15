package geeksforgeeks.two.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrint {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right= new Node(6);

        LevelOrderPrint ob = new LevelOrderPrint();
        ob.printLevel(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    public void printLevel(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                Node node = q.remove();
                System.out.print(node.data + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            System.out.println();
        }
    }

}
