package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/level-order-tree-traversal/
public class LevelOrderTreeTraversal {

    public static void main(String args[]) {
        /* creating a binary tree and entering
         the nodes */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        printLevelOrder(root);
    }

    static void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.key + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }
}
