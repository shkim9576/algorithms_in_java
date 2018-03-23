package g4g2nd.binarytree;

public class CheckAllLeafSameLevel {

    Node root;
    public static void main(String[] args) {
        CheckAllLeafSameLevel tree = new CheckAllLeafSameLevel();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(1);
        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    boolean check(Node root) {
        if (root == null) return true;
        return helper(root, 0);
    }

    int cLevel = -1;
    boolean helper(Node root, int level) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            if (cLevel == -1) {
                cLevel = level;
                return true;
            }
            return cLevel == level;
        }

        return helper(root.left, level + 1) && helper(root.right, level + 1);
    }
}
