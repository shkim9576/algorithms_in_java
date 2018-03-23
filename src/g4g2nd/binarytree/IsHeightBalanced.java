package g4g2nd.binarytree;

public class IsHeightBalanced {

    Node root;
    public static void main(String[] args) {
        IsHeightBalanced tree = new IsHeightBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if(tree.isHeightBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }


    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean isHeightBalanced(Node root) {
        if (root == null) return true;

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.abs(leftH - rightH) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right);
    }

    int getHeight(Node root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
