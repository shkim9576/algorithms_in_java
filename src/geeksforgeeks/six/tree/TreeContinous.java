package geeksforgeeks.six.tree;

public class TreeContinous {

    public static void main(String[] args) {
        TreeContinous o = new TreeContinous();

        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        System.out.println(o.isContinuous(root));
    }

    boolean isContinuous(Node root) {
        if (root == null) return true;

        return dfs(root, root.data + 1);
    }

    boolean dfs(Node root, int parentVal) {
        if (root == null) return true;

        if (Math.abs(root.data - parentVal) != 1) return false;

        return dfs(root.left, root.data) && dfs(root.right, root.data);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int d) {
            this.data = d;
        }
    }
}
