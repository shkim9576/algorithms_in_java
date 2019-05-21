package geeksforgeeks.six.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfSiblings {

    public static void main(String args[]) {
        // Creating a generic tree as shown in above figure
        Node root = new Node(50);
        (root.child).add(new Node(2));
        (root.child).add(new Node(30));
        (root.child).add(new Node(14));
        (root.child).add(new Node(60));
        (root.child.get(0).child).add(new Node(15));
        (root.child.get(0).child).add(new Node(25));
        (root.child.get(0).child.get(1).child).add(new Node(70));
        (root.child.get(0).child.get(1).child).add(new Node(100));
        (root.child.get(1).child).add(new Node(6));
        (root.child.get(1).child).add(new Node(1));
        (root.child.get(2).child).add(new Node(7));
        (root.child.get(2).child.get(0).child).add(new Node(17));
        (root.child.get(2).child.get(0).child).add(new Node(99));
        (root.child.get(2).child.get(0).child).add(new Node(27));
        (root.child.get(3).child).add(new Node(16));

        // Node whose number of
        // siblings is to be calculated
        int x = 100;

        // Function calling
        System.out.println(numberOfSiblings(root, x));
    }

    static int numberOfSiblings(Node root, int target) {
        if (root == null) return -1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            for (Node c : node.child) {
                if (c.data == target) return node.child.size() - 1;
                q.add(c);
            }
        }
        return -1;
    }

    static class Node {
        int data;
        List<Node> child = new ArrayList<>();

        Node(int d) {
            this.data = d;
        }
    }
}
