package dsalg.two.tree;

public class PrintPath {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        PrintPath o = new PrintPath();
        o.printPath(root);
    }

    void printPath(Node root) {
        if (root == null) return;
        dfs(root, "");
    }

    void dfs(Node root, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(path + " " + root.data);
            return;
        }

        dfs(root.left, path + " " + root.data);
        dfs(root.right, path + " " + root.data);
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
