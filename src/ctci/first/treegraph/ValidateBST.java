package ctci.first.treegraph;

public class ValidateBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);

        ValidateBST ob = new ValidateBST();
        System.out.println(ob.validate(root));
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

    boolean validate(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val < root.val) return false;

        return validate(root.left) && validate(root.right);
    }

}
