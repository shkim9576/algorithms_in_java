package g4g1st.binarytree.excercise;

public class IsBST {
    // https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);  // false  this node is bigger than root (3)

        IsBST ob = new IsBST();
        System.out.println(ob.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(ob.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    boolean isBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max) return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

}
