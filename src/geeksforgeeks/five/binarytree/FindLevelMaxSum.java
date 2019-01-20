package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
public class FindLevelMaxSum {

    //Maximum level sum is 17
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println("Maximum level sum is " + levelSum(root));
    }

    static int levelSum(Node root) {
        Queue<Node> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                sum += n.key;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
