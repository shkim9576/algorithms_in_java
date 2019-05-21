package dsalg.two.tree;

import java.util.ArrayList;
import java.util.List;

public class SumNary {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(1).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.get(1).children.get(0).children.add(new Node(8));
        root.children.get(1).children.get(0).children.add(new Node(9));
        root.children.get(1).children.get(0).children.add(new Node(10));

        SumNary o = new SumNary();
        System.out.println(o.sumNary(root));

    }

    int sumNary(Node root) {
        if (root == null) return 0;
        int sum = 0;
        for (Node c : root.children) {
            sum += sumNary(c);
        }
        return sum + root.data;
    }

    static class Node {
        int data;
        List<Node> children = new ArrayList<>();

        Node(int d) {
            this.data = d;
        }
    }
}
