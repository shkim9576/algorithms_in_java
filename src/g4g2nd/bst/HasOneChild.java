package g4g2nd.bst;

public class HasOneChild {

    Node root;
    public static void main(String[] args) {
        HasOneChild tree = new HasOneChild();
        tree.root = new Node(20);
        tree.root.left = new Node(10);
        tree.root.left.right = new Node(11);
        tree.root.left.right.right = new Node(13);
        tree.root.left.right.right.left = new Node(12);

        HasOneChild ob = new HasOneChild();
        System.out.println(ob.hasOneChild(tree.root));
    }


    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean hasOneChild(Node root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) return false;

        return hasOneChild(root.left) && hasOneChild(root.right);
    }
}
