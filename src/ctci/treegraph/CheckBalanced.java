package ctci.treegraph;

public class CheckBalanced {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        CheckBalanced ob = new CheckBalanced();
        System.out.println(ob.isBalanced(root));

    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    boolean isBalanced(Node root) {
        return getLevel(root) != -1;
    }

    int getLevel(Node root) {
        if (root == null) return 0;
        int l = getLevel(root.left);
        if (l == -1) return -1;

        int r = getLevel(root.right);
        if (r == -1) return -1;

        if (Math.abs(l-r) > 1) return -1;
        else return (l > r) ? l + 1 : r + 1;
    }

}
