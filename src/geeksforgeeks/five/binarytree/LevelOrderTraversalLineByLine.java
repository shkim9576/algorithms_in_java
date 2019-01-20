package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/level-order-traversal-line-line-set-3-using-one-queue/
public class LevelOrderTraversalLineByLine {

    //1
    //2 3
    //4 5 6
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        levelOrder(root);
    }

    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                System.out.print(n.key + " ");

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }
}
