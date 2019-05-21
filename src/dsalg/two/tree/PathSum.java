package dsalg.two.tree;

public class PathSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        PathSum o = new PathSum();
        System.out.println(o.pathSum(root, 10));
        System.out.println(o.pathSum(root, 110));
    }

    boolean pathSum(Node root, int sum) {
        if (root == null) return false;
        if (root.data == sum) return true;
        return pathSum(root.left, sum - root.data) || pathSum(root.right, sum - root.data);
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
