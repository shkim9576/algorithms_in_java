package g4g2nd.binarytree;

public class ChildrenSumProperty {

    Node root;

    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        if (tree.isSumProperty(tree.root))
            System.out.println("The given tree satisfies children"
                               + " sum property");
        else
            System.out.println("The given tree does not satisfy children"
                               + " sum property");
    }


    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    boolean isSumProperty(Node root) {
        if (root == null || isLeaf(root)) return true;

        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        return sum == root.data && isSumProperty(root.left) && isSumProperty(root.right);
    }

    boolean isLeaf(Node root) {
        return root != null && (root.left == null && root.right == null);
    }
}
