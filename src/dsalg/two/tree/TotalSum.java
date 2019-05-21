package dsalg.two.tree;

public class TotalSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        TotalSum o = new TotalSum();
        System.out.println(o.totalSum(root));
    }

    int totalSum(Node root) {
        if (root == null) return 0;
        return totalSum(root.left) + totalSum(root.right) + root.data;
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
