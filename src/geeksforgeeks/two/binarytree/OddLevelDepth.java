package geeksforgeeks.two.binarytree;

public class OddLevelDepth {

    Node root;
    public static void main(String[] args) {
        int k = 45;
        OddLevelDepth tree = new OddLevelDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.root.right.left.right.left = new Node(9);
        tree.root.right.right.right.right = new Node(10);
        tree.root.right.right.right.right.left = new Node(11);
        System.out.println(tree.depthOfOddLeaf(tree.root) +
                           " is the required depth");
    }

    static class Node {
        int data;
        Node left, right;
        Node (int d) {
            data = d;
        }
    }

    int depthOfOddLeaf(Node root) {
        return helper(root, 0);
    }

    int helper(Node root, int level) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (level % 2 == 1) {
                return level;
            }
        }

        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);
        return Math.max(left, right);
    }
}
