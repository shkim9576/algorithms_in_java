package geeksforgeeks.five.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
public class DifferenceBetweenSumOfLevels {

    //diffence between sums is -9
    public static void main(String args[]) {
        // construct a tree
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);

        System.out.println("diffence between sums is " +
                evenOddLevelDifference(root));
    }

    static int evenOddLevelDifference(Node root) {
        Queue<Node> q = new LinkedList<>();
        int even = 0, odd = 0;
        boolean isOdd = true;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.remove();
                if (isOdd) odd += n.key;
                else even += n.key;

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            isOdd = isOdd ? false : true;
        }

        return odd - even;
    }
}
