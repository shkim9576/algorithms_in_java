package g4g2nd.binarytree;

public class IsSumTree {

    Node root;
    public static void main(String[] args) {
        IsSumTree tree = new IsSumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);

        if (tree.isSumTree(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isSumTree(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int sum = 0;
        sum += getSum(root.left);
        sum += getSum(root.right);

        return root.data == sum && isSumTree(root.left) && isSumTree(root.right);
    }

    int getSum(Node root) {
        if (root == null) return 0;
        return getSum(root.left) + getSum(root.right) + root.data;
    }
}
